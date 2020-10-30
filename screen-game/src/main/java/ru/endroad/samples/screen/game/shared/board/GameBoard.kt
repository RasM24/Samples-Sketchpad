package ru.endroad.samples.screen.game.shared.board

import ru.endroad.samples.screen.game.shared.animal.Animal

class GameBoard(
	private val fieldLengthXAxis: Int,
	private val fieldLengthYAxis: Int,
) {

	private val area: Field<Subject?> = Array(fieldLengthXAxis) { Array(fieldLengthYAxis) { null } }

	fun getSubjects(): List<Subject> {
		val subjects = mutableListOf<Subject>()
		area.forEachAll { it?.let(subjects::add) }
		return subjects
	}

	fun getField(): Field<Subject?> =
		area

	fun getLocateArea(cell: Position): Map<DirectionMove, Subject?> {
		val map = mutableMapOf<DirectionMove, Subject?>()

		DirectionMove.values().forEach { move ->
			(cell + move.position).getOrNull()?.let { map[move] = area[it.x][it.y] }
		}

		return map
	}

	fun getCell(position: Position): Subject? =
		area[position]

	fun isEmpty(position: Position): Boolean =
		runCatching { area[position] == null }
			.getOrDefault(false)

	fun getPosition(animal: Subject): Position {
		area.forEachIndexedAll { x, y, subject ->
			if (subject?.id == animal.id) {
				return Position(x, y)
			}
		}
		throw IllegalStateException("Животное не найдено")
	}

	private fun Position.getOrNull(): Position? =
		if (x in 0 until fieldLengthXAxis && y in 0 until fieldLengthYAxis) this
		else null

	fun putAnimal(cell: Position, subject: Subject?) {
		area[cell] = subject
	}

	fun moveAnimal(targetCell: Position, targetSubject: Animal) {
		val cell = getPosition(targetSubject)
		area[cell] = null
		area[targetCell] = targetSubject
	}

	fun killAnimal(targetSubject: Animal) {
		val cell = getPosition(targetSubject)
		area[cell] = null
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true

		if (other !is GameBoard) return false
		if (this.fieldLengthXAxis != other.fieldLengthXAxis) return false
		if (this.fieldLengthYAxis != other.fieldLengthYAxis) return false

		for (xAxis in 0 until fieldLengthXAxis)
			for (yAxis in 0 until fieldLengthYAxis) {
				val cell = Position(xAxis, yAxis)
				if (this.area[cell] != other.area[cell]) return false
			}

		return true
	}
}