package ru.endroad.samples.screen.game.shared.board

data class Position(val x: Int, val y: Int) {

	operator fun plus(increment: Position): Position =
		Position(this.x + increment.x, this.y + increment.y)

	operator fun minus(decrement: Position): Position =
		Position(this.x - decrement.x, this.y - decrement.y)

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is Position) return false

		return other.x == x && other.y == y
	}

	override fun hashCode(): Int {
		var result = x
		result = 31 * result + y
		return result
	}
}