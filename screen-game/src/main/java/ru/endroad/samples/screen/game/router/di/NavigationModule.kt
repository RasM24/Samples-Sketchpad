package ru.endroad.samples.screen.game.router.di

import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.samples.screen.game.R
import ru.endroad.samples.screen.game.router.navigator.Navigator
import ru.endroad.samples.screen.game.router.navigator.RootNavigator
import ru.endroad.samples.screen.game.router.routers.MainRouter

val moduleNavigation = module {
	single<Navigator> { RootNavigator(R.id.root) }

	single<MainRouter>()
}