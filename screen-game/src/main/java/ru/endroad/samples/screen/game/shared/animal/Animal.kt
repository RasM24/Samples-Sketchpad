package ru.endroad.samples.screen.game.shared.animal

import ru.endroad.samples.screen.game.shared.board.Subject

sealed class Animal : Subject

data class Grampus(
	override val id: Int,
) : Animal()

data class Penguin(
	override val id: Int,
) : Animal()