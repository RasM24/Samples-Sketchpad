package ru.endroad.samples.screen.game.shared.board

typealias Field<T> = Array<Array<T>>

inline fun <reified T : Any?> emptyField(element: T) = arrayOf(arrayOf(element))

inline fun <reified T> Field<T>.forEachAll(action: (T) -> Unit) {
	this.forEach { line -> line.forEach(action) }
}

inline fun <reified T> Field<T>.forEachIndexedAll(action: (x: Int, y: Int, T) -> Unit) {
	this.forEachIndexed { x, line -> line.forEachIndexed { y, cell -> action(x, y, cell) } }
}