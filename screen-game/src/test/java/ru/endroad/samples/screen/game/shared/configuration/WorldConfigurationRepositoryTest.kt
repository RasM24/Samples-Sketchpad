package ru.endroad.samples.screen.game.shared.configuration

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class WorldConfigurationRepositoryTest {

	private val configuration = WorldConfiguration(10, 10, 0.5f, 0.05f)
	private val repository = WorldConfigurationRepository()

	@Test(expected = RuntimeException::class)
	fun `get configuration without set`() {
		repository.get()
	}

	@Test
	fun `get configuration after set`() {
		repository.set(configuration)

		assertEquals(configuration, repository.get())
	}
}