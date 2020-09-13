package ru.endroad.samples.login.router.di

import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.samples.login.R
import ru.endroad.samples.login.router.navigator.Navigator
import ru.endroad.samples.login.router.navigator.RootNavigator
import ru.endroad.samples.login.router.routers.LoginRouter
import ru.endroad.samples.login.router.routers.MainRouter

val moduleNavigation = module {
	single<Navigator> { RootNavigator(R.id.root) }

	single<MainRouter>()
	single<LoginRouter>()
}