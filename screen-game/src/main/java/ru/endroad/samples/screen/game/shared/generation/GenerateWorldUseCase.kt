package ru.endroad.samples.screen.game.shared.generation

import ru.endroad.samples.screen.game.shared.animal.Animal
import ru.endroad.samples.screen.game.shared.animal.Grampus
import ru.endroad.samples.screen.game.shared.animal.Penguin
import ru.endroad.samples.screen.game.shared.board.GameBoard
import ru.endroad.samples.screen.game.shared.configuration.GetInitiateGrampusCountUseCase
import ru.endroad.samples.screen.game.shared.configuration.GetInitiatePenguinCountUseCase
import ru.endroad.samples.screen.game.shared.configuration.WorldConfigurationRepository

class GenerateWorldUseCase(
	private val animalFactory: AnimalFactory,
	private val getInitiatePenguinCount: GetInitiatePenguinCountUseCase,
	private val getInitiateGrampusCount: GetInitiateGrampusCountUseCase,
	private val getEmptyPosition: GetEmptyPositionUseCase,
	private val configurationRepository: WorldConfigurationRepository,
) {

	operator fun invoke(): GameBoard {
		val configuration = configurationRepository.get()
		val board = GameBoard(configuration.fieldLengthXAxis, configuration.fieldLengthYAxis)

		repeat(getInitiatePenguinCount()) { board.generateAnimal<Penguin>() }
		repeat(getInitiateGrampusCount()) { board.generateAnimal<Grampus>() }

		return board
	}

	private inline fun <reified T : Animal> GameBoard.generateAnimal() {
		val position = getEmptyPosition(this)
		val animal = animalFactory.create(T::class)
		putAnimal(position, animal)
	}
}