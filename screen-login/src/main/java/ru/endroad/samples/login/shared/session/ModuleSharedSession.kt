package ru.endroad.samples.login.shared.session

import org.koin.dsl.module
import org.koin.experimental.builder.single

val moduleShareSession = module {
	single<CreateSessionUseCase>()
}