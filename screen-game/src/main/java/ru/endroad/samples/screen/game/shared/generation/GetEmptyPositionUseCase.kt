package ru.endroad.samples.screen.game.shared.generation

import ru.endroad.samples.screen.game.shared.board.GameBoard
import ru.endroad.samples.screen.game.shared.board.Position
import kotlin.random.Random

class GetEmptyPositionUseCase {

	operator fun invoke(board: GameBoard): Position {
		val fieldLengthXAxis = board.getField().size
		val fieldLengthYAxis = board.getField()[0].size

		while (true) {
			val position = getRandomPosition(fieldLengthXAxis, fieldLengthYAxis)
			if (board.isEmptyPosition(position))
				return position
		}
	}

	private fun getRandomPosition(fieldLengthXAxis: Int, fieldLengthYAxis: Int): Position =
		Position(Random.nextInt(fieldLengthXAxis), Random.nextInt(fieldLengthYAxis))

	private fun GameBoard.isEmptyPosition(position: Position): Boolean =
		getCell(position) == null
}