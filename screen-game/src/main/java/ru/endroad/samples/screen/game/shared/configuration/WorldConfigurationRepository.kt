package ru.endroad.samples.screen.game.shared.configuration

class WorldConfigurationRepository {

	private var configuration: WorldConfiguration? = null

	fun get(): WorldConfiguration =
		requireNotNull(configuration) { "Пожалуйста сначала установите настройки для мира" }

	fun set(configuration: WorldConfiguration) {
		this.configuration = configuration
	}
}