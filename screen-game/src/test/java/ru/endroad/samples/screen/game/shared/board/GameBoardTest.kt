package ru.endroad.samples.screen.game.shared.board

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import ru.endroad.samples.screen.game.shared.animal.Grampus
import ru.endroad.samples.screen.game.shared.animal.Penguin

class GameBoardTest {

	private lateinit var gameBoard: GameBoard

	private val firstInitiatePosition = Position(0, 0)
	private val secondInitiatePosition = Position(1, 1)
	private val thirdInitiatePosition = Position(2, 2)
	private val firstAnimal: Penguin = mock { on { id } doReturn 1 }
	private val secondAnimal: Penguin = mock { on { id } doReturn 2 }
	private val thirdAnimal: Grampus = mock { on { id } doReturn 3 }

	@Before
	fun setUp() {
		gameBoard = GameBoard(3, 3)
		gameBoard.putAnimal(firstInitiatePosition, firstAnimal)
		gameBoard.putAnimal(secondInitiatePosition, secondAnimal)
		gameBoard.putAnimal(thirdInitiatePosition, thirdAnimal)
	}

	@Test
	fun getSubjects() {
		val expectedSubjects = listOf(firstAnimal, secondAnimal, thirdAnimal)

		assertEquals(expectedSubjects, gameBoard.getSubjects())
	}

	@Test
	fun getField() {
		val expectedField: Field<Subject?> = fieldOf(3, 3, null)
		expectedField[firstInitiatePosition] = firstAnimal
		expectedField[secondInitiatePosition] = secondAnimal
		expectedField[thirdInitiatePosition] = thirdAnimal

		assertArrayEquals(expectedField, gameBoard.getField())
	}

	@Test
	fun getLocateArea() {
		val expectedLocateArea: Map<DirectionMove, Subject?> = mapOf(
			DirectionMove.UP to null,
			DirectionMove.UP_RIGHT to secondAnimal,
			DirectionMove.RIGHT to null,
		)

		assertEquals(expectedLocateArea, gameBoard.getLocateArea(firstInitiatePosition))
	}

	@Test
	fun getAnimalCell() {
		assertEquals(firstAnimal, gameBoard.getCell(firstInitiatePosition))
	}

	@Test
	fun getEmptyCell() {
		val emptyPosition = Position(0, 1)

		assertEquals(null, gameBoard.getCell(emptyPosition))
	}

	@Test
	fun putAnimal() {
		val targetPosition = Position(0, 1)
		val animal: Penguin = mock { on { id } doReturn 4 }

		gameBoard.putAnimal(targetPosition, animal)

		assertEquals(animal, gameBoard.getCell(targetPosition))
	}

	@Test
	fun moveAnimal() {
		val targetPosition = Position(0, 1)
		val expectedField: Field<Subject?> = fieldOf(3, 3, null)
		expectedField[targetPosition] = firstAnimal
		expectedField[secondInitiatePosition] = secondAnimal
		expectedField[thirdInitiatePosition] = thirdAnimal

		gameBoard.moveAnimal(targetPosition, firstAnimal)

		assertArrayEquals(expectedField, gameBoard.getField())
	}

	@Test
	fun killAnimal() {
		val expectedField: Field<Subject?> = fieldOf(3, 3, null)
		expectedField[secondInitiatePosition] = secondAnimal
		expectedField[thirdInitiatePosition] = thirdAnimal

		gameBoard.killAnimal(firstAnimal)

		assertArrayEquals(expectedField, gameBoard.getField())
	}
}