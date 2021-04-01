package ru.endroad.sample.screen.navigation.router.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.router.navigator.NavigationCommandExecutor
import ru.endroad.sample.screen.navigation.router.navigator.NavigationCommandStack
import ru.endroad.sample.screen.navigation.router.navigator.NavigationManager
import ru.endroad.sample.screen.navigation.router.navigator.Navigator

val rootNavigatorQualifier = named("RootNavigator")
val contentNavigatorQualifier = named("ContentNavigator")

val moduleNavigation = module {
	single<NavigationManager>()

	single<NavigationCommandStack>()
	single<NavigationCommandExecutor>()

	single(rootNavigatorQualifier) { Navigator(R.id.root, get(), get()) }
	single(contentNavigatorQualifier) { Navigator(R.id.content, get(), get()) }
}