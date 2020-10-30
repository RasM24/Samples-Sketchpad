package ru.endroad.samples.screen.game.shared.configuration

class GetInitiateGrampusCountUseCase(private val configurationRepository: WorldConfigurationRepository) {

	operator fun invoke(): Int =
		configurationRepository.get().run {
			val cellCount = fieldLengthXAxis * fieldLengthYAxis
			cellCount * percentGrampus
		}.toInt()
}