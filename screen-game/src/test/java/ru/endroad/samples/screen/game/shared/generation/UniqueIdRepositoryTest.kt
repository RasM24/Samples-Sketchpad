package ru.endroad.samples.screen.game.shared.generation

import junit.framework.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class UniqueIdRepositoryTest {

	private val repository = UniqueIdRepository()

	@Test
	fun `get unique id without reset`() {
		val firstId = repository.get()
		val secondId = repository.get()
		val thirdId = repository.get()

		assertNotEquals(firstId, secondId)
		assertNotEquals(firstId, thirdId)
		assertNotEquals(secondId, thirdId)
	}

	@Test
	fun `get unique id with reset`() {
		repository.reset()
		val firstId = repository.get()
		val secondId = repository.get()
		val thirdId = repository.get()

		assertNotEquals(firstId, secondId)
		assertNotEquals(firstId, thirdId)
		assertNotEquals(secondId, thirdId)
	}

	@Test
	fun `check reset id repository`() {
		repository.get()
		repository.get()
		repository.get()
		repository.reset()

		assertEquals(0, repository.get())
	}
}