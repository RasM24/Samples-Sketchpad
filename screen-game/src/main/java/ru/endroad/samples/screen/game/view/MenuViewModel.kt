package ru.endroad.samples.screen.game.view

import androidx.lifecycle.ViewModel
import ru.endroad.samples.screen.game.router.routers.MainRouter
import ru.endroad.samples.screen.game.shared.configuration.WorldConfiguration
import ru.endroad.samples.screen.game.shared.configuration.WorldConfigurationRepository

class MenuViewModel(
	private val configurationRepository: WorldConfigurationRepository,
	private val router: MainRouter,
) : ViewModel() {

	private val defaultConfiguration = WorldConfiguration(
		10,
		15,
		0.5f,
		0.05f
	)

	fun startGame() {
		configurationRepository.set(defaultConfiguration)
		router.startGame()
	}
}