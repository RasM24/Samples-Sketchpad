package ru.endroad.samples.login.router.di

import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.samples.login.application.NavigationViewModel
import ru.endroad.samples.login.di.viewModel
import ru.endroad.samples.login.router.navigator.Navigator
import ru.endroad.samples.login.router.navigator.RootNavigator
import ru.endroad.samples.login.router.routers.LoginRouter
import ru.endroad.samples.login.router.routers.MainRouter
import ru.endroad.samples.login.router.routers.MockSocialSignRouter

val moduleNavigation = module {
	viewModel<NavigationViewModel>()
	single<Navigator> { RootNavigator() }

	single<MainRouter>()
	single<LoginRouter>()
	single<MockSocialSignRouter>()
}