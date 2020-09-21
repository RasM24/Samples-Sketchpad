package ru.endroad.samples.screen.listing.router.di

import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.samples.screen.listing.R
import ru.endroad.samples.screen.listing.router.navigator.Navigator
import ru.endroad.samples.screen.listing.router.navigator.RootNavigator
import ru.endroad.samples.screen.listing.router.routers.MainRouter

val moduleNavigation = module {
	single<Navigator> { RootNavigator(R.id.root) }
	single<MainRouter>()
}