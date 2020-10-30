package ru.endroad.samples.screen.game.shared.engine

import ru.endroad.samples.screen.game.shared.board.GameBoard

class Engine {

	private lateinit var gameBoard: GameBoard

	fun setGameBoard(gameBoard: GameBoard) {
		this.gameBoard = gameBoard
	}

	fun endTurn() = Unit
}