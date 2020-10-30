package ru.endroad.samples.screen.game.shared.configuration

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert.assertEquals
import org.junit.Test

class GetInitiatePenguinCountUseCaseTest {

	private val configuration = WorldConfiguration(10, 15, 0.5f, 0.05f)
	private val configurationRepository: WorldConfigurationRepository = mock {
		on { get() } doReturn configuration
	}

	private val useCase = GetInitiatePenguinCountUseCase(configurationRepository)

	@Test
	fun `check count`() {
		val expectedCount = 75

		assertEquals(expectedCount, useCase())
	}
}