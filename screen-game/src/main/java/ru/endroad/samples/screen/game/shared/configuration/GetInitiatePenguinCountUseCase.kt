package ru.endroad.samples.screen.game.shared.configuration

class GetInitiatePenguinCountUseCase(private val configurationRepository: WorldConfigurationRepository) {

	operator fun invoke(): Int =
		configurationRepository.get().run {
			val cellCount = fieldLengthXAxis * fieldLengthYAxis
			cellCount * percentPenguin
		}.toInt()
}