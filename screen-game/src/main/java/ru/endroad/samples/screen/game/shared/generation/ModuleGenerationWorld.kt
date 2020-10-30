package ru.endroad.samples.screen.game.shared.generation

import org.koin.dsl.module
import org.koin.experimental.builder.single

val moduleGenerationWorld = module {
	single<UniqueIdRepository>()
	single<GetEmptyPositionUseCase>()
	single<AnimalFactory>()

	single<BreedAnimalUseCase>()
	single<GenerateWorldUseCase>()
}