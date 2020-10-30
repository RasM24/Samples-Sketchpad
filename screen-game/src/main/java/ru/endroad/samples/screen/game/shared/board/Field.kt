package ru.endroad.samples.screen.game.shared.board

typealias Field<T> = Array<Array<T>>

inline fun <reified T : Any?> emptyField(element: T) = arrayOf(arrayOf(element))

inline fun <reified T : Any?> fieldOf(sizeX: Int, sizeY: Int, initiateElement: T) = Array(sizeX) { Array(sizeY) { initiateElement } }

inline fun <reified T : Any?, reified R : Any?> Array<out T>.mapToArray(transform: (T) -> R): Array<R> =
	Array(size) { index -> transform(this[index]) }

inline fun <reified T> Field<T>.forEachAll(action: (T) -> Unit) {
	this.forEach { line -> line.forEach(action) }
}

inline fun <reified T> Field<T>.forEachIndexedAll(action: (x: Int, y: Int, T) -> Unit) {
	this.forEachIndexed { x, line -> line.forEachIndexed { y, cell -> action(x, y, cell) } }
}

inline operator fun <reified T : Any?> Field<T>.get(cell: Position) =
	this[cell.x][cell.y]

inline operator fun <reified T : Any?> Field<T>.set(cell: Position, value: T) {
	this[cell.x][cell.y] = value
}