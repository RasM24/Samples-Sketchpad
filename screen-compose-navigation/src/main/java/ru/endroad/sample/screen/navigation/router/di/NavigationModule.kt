package ru.endroad.sample.screen.navigation.router.di

import org.koin.dsl.module
import org.koin.experimental.builder.single
import ru.endroad.sample.screen.navigation.router.navigator.NavigationCommandExecutor
import ru.endroad.sample.screen.navigation.router.navigator.NavigationCommandStack
import ru.endroad.sample.screen.navigation.router.navigator.NavigationManager
import ru.endroad.sample.screen.navigation.router.navigator.Navigator

val moduleNavigation = module {
	single<NavigationManager>()

	single<NavigationCommandStack>()
	single<NavigationCommandExecutor>()

	single<Navigator>()
}