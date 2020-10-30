package ru.endroad.samples.screen.game.shared.configuration

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert.assertEquals
import org.junit.Test

class GetInitiateGrampusCountUseCaseTest {

	private val configuration = WorldConfiguration(10, 15, 0.5f, 0.05f)
	private val configurationRepository: WorldConfigurationRepository = mock {
		on { get() } doReturn configuration
	}

	private val useCase = GetInitiateGrampusCountUseCase(configurationRepository)

	@Test
	fun `check count`() {
		val expectedCount = 7

		assertEquals(expectedCount, useCase())
	}
}