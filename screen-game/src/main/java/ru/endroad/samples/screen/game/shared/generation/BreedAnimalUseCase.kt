package ru.endroad.samples.screen.game.shared.generation

import ru.endroad.samples.screen.game.shared.animal.Animal
import ru.endroad.samples.screen.game.shared.board.DirectionMove
import ru.endroad.samples.screen.game.shared.board.GameBoard
import ru.endroad.samples.screen.game.shared.board.Position

class BreedAnimalUseCase(
	private val animalFactory: AnimalFactory,
) {

	operator fun <T : Animal> invoke(gameBoard: GameBoard, parentAnimal: T) {
		val parentPosition = gameBoard.getPosition(parentAnimal)
		val childPosition = gameBoard.getPositionForChild(parentPosition) ?: return

		val child = animalFactory.create(parentAnimal::class)
		gameBoard.putAnimal(childPosition, child)
	}

	private fun GameBoard.getPositionForChild(position: Position): Position? =
		DirectionMove.values()
			.filter { isEmpty(it.position + position) }
			.randomOrNull()
			?.position?.let { it + position }
}