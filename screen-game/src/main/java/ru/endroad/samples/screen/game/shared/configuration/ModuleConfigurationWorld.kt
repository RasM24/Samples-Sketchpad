package ru.endroad.samples.screen.game.shared.configuration

import org.koin.dsl.module
import org.koin.experimental.builder.single

val moduleConfigurationWorld = module {
	single<WorldConfigurationRepository>()

	single<GetInitiatePenguinCountUseCase>()
	single<GetInitiateGrampusCountUseCase>()
}