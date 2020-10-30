package ru.endroad.samples.screen.game.shared.engine

import org.koin.dsl.module
import org.koin.experimental.builder.single

val moduleEngine = module {
	single<FindPreyUseCase>()
	single<GetTargetPositionForMoveUseCase>()
	single<Engine>()
}