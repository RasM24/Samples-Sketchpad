package ru.endroad.samples.screen.game.shared.engine

import ru.endroad.samples.screen.game.shared.animal.Animal
import ru.endroad.samples.screen.game.shared.animal.Penguin
import ru.endroad.samples.screen.game.shared.board.GameBoard

class FindPreyUseCase {

	operator fun invoke(gameBoard: GameBoard, predator: Animal): Penguin? =
		predator
			.let(gameBoard::getPosition)
			.let(gameBoard::getLocateArea)
			.values.find { it is Penguin } as? Penguin
}