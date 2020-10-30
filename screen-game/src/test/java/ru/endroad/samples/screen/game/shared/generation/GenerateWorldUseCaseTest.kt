package ru.endroad.samples.screen.game.shared.generation

import com.nhaarman.mockito_kotlin.*
import org.junit.Assert.assertEquals
import org.junit.Test
import ru.endroad.samples.screen.game.shared.animal.Animal
import ru.endroad.samples.screen.game.shared.animal.Grampus
import ru.endroad.samples.screen.game.shared.animal.Penguin
import ru.endroad.samples.screen.game.shared.board.GameBoard
import ru.endroad.samples.screen.game.shared.board.Position
import ru.endroad.samples.screen.game.shared.configuration.*

class GenerateWorldUseCaseTest {

	private val animalFactory: AnimalFactory = mock()
	private val getInitiatePenguinCount: GetInitiatePenguinCountUseCase = mock()
	private val getInitiateGrampusCount: GetInitiateGrampusCountUseCase = mock()
	private val getEmptyPosition: GetEmptyPositionUseCase = mock()

	private val configuration: WorldConfiguration = mock {
		on { fieldLengthXAxis } doReturn 3
		on { fieldLengthYAxis } doReturn 3
	}
	private val configurationRepository: WorldConfigurationRepository = mock {
		on { get() } doReturn configuration
	}

	private val useCase = GenerateWorldUseCase(
		animalFactory,
		getInitiatePenguinCount,
		getInitiateGrampusCount,
		getEmptyPosition,
		configurationRepository,
	)

	@Test
	fun `check world generation`() {
		val penguinPosition = Position(0, 0)
		val grampusPosition = Position(1, 1)
		val penguin: Penguin = mock { on { id } doReturn 0 }
		val grampus: Grampus = mock { on { id } doReturn 1 }
		whenever(getInitiatePenguinCount.invoke()).doReturn(1)
		whenever(getInitiateGrampusCount.invoke()).doReturn(1)
		whenever(animalFactory.create<Animal>(any())).doReturn(penguin, grampus)
		whenever(getEmptyPosition.invoke(any())).doReturn(penguinPosition, grampusPosition)

		val actualWorld = useCase()
		val expectedWorld = GameBoard(3, 3).apply {
			putAnimal(penguinPosition, penguin)
			putAnimal(grampusPosition, grampus)
		}

		assertEquals(expectedWorld, actualWorld)
	}
}