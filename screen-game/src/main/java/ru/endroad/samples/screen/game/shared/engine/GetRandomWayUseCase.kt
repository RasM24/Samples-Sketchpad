package ru.endroad.samples.screen.game.shared.engine

import ru.endroad.samples.screen.game.shared.animal.Animal
import ru.endroad.samples.screen.game.shared.board.DirectionMove
import ru.endroad.samples.screen.game.shared.board.GameBoard
import ru.endroad.samples.screen.game.shared.board.Position

class GetTargetPositionForMoveUseCase {

	operator fun invoke(gameBoard: GameBoard, animal: Animal): Position? =
		animal
			.let(gameBoard::getPosition)
			.let(::getRandomWay)
			.takeIf(gameBoard::isEmpty)

	private fun getRandomWay(currentPosition: Position) =
		currentPosition + DirectionMove.values().random().position
}