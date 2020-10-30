package ru.endroad.samples.screen.game.shared.board

enum class DirectionMove(var position: Position) {
	LEFT(Position(0, -1)),
	UP_LEFT(Position(1, -1)),
	UP(Position(1, 0)),
	UP_RIGHT(Position(1, 1)),
	RIGHT(Position(0, 1)),
	DOWN_RIGHT(Position(-1, 1)),
	DOWN(Position(-1, 0)),
	DOWN_LEFT(Position(-1, -1)),
}