package ru.endroad.samples.screen.game.shared.generation

class UniqueIdRepository {

	private var nextId: Int = 0
		get() = field++

	fun get(): Int = nextId

	fun reset() {
		nextId = 0
	}
}