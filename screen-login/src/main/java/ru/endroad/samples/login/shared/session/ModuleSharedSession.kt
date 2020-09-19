package ru.endroad.samples.login.shared.session

import org.koin.dsl.module
import org.koin.experimental.builder.single
import org.koin.experimental.builder.singleBy

val moduleShareSession = module {
	singleBy<SessionDataSource, SessionLocalDataSource>()

	single<CreateSessionUseCase>()
	single<IsAuthorizedUseCase>()
	single<LogoutUseCase>()
}