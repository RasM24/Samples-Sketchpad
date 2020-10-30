package ru.endroad.samples.screen.game.shared.engine

import ru.endroad.samples.screen.game.shared.animal.*
import ru.endroad.samples.screen.game.shared.board.GameBoard
import ru.endroad.samples.screen.game.shared.board.Position
import ru.endroad.samples.screen.game.shared.generation.BreedAnimalUseCase

class Engine(
	private val breedAnimal: BreedAnimalUseCase,
	private val findPrey: FindPreyUseCase,
	private val getTargetPositionForMove: GetTargetPositionForMoveUseCase,
) {

	private lateinit var gameBoard: GameBoard

	fun setGameBoard(gameBoard: GameBoard) {
		this.gameBoard = gameBoard
	}

	fun endTurn() {
		gameBoard.getAnimals().forEachAlive { animal ->

			if (animal is Predator) {
				findPrey(gameBoard, animal)
					?.let { prey ->
						animal.attack(prey) {
							(animal as? Hungry)?.hunger?.feeding()
							gameBoard.moveAnimal(it, animal)
						}
					}
					?: animal.moving()
			} else {
				animal.moving()
			}

			(animal as? Pregnant)?.handle { breedAnimal(gameBoard, animal) }
			(animal as? Hungry)?.handle { gameBoard.killAnimal(animal) }
		}
	}

	private fun List<Animal>.forEachAlive(action: (Animal) -> Unit) {
		forEach { animal ->
			val isAlive = animal in gameBoard.getAnimals()
			if (isAlive) {
				action(animal)
			}
		}
	}

	private fun Predator.attack(prey: Animal, onAttack: (Position) -> Unit) {
		val penguinPosition = gameBoard.getPosition(prey)
		gameBoard.killAnimal(prey)

		onAttack(penguinPosition)
	}

	private fun Animal.moving() {
		getTargetPositionForMove(gameBoard, this)?.let {
			gameBoard.moveAnimal(it, this)
		}
	}

	private fun Pregnant.handle(onBirth: () -> Unit) {
		if (pregnancy.isChildbirth()) {
			onBirth()
			pregnancy.cancel()
		} else {
			pregnancy.proceed()
		}
	}

	private fun Hungry.handle(diedOfHunger: () -> Unit) {
		if (hunger.isHunger()) {
			diedOfHunger()
		} else {
			hunger.proceed()
		}
	}
}
