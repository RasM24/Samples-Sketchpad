package ru.endroad.samples.screen.game.shared.animal

import ru.endroad.samples.screen.game.shared.board.Subject

sealed class Animal : Subject

data class Grampus(
	override val id: Int,
	override val pregnancy: Pregnancy,
	override val hunger: Hunger,
) : Animal(), Predator, Pregnant, Hungry

data class Penguin(
	override val id: Int,
	override val pregnancy: Pregnancy,
) : Animal(), Pregnant