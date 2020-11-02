package ru.endroad.sample.screen.navigation.router.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.router.navigator.Navigator
import ru.endroad.sample.screen.navigation.router.navigator.NavigatorHolder

val rootNavigatorQualifier = named("RootNavigator")
val contentNavigatorQualifier = named("ContentNavigator")

val moduleNavigation = module {
	single<NavigatorHolder>()

	single(rootNavigatorQualifier) { Navigator(R.id.root, get()) }
	single(contentNavigatorQualifier) { Navigator(R.id.content, get()) }
}