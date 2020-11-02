package ru.endroad.sample.screen.navigation.router.di

import org.koin.dsl.module
import org.koin.experimental.builder.singleBy
import ru.endroad.sample.screen.navigation.application.HubRouter
import ru.endroad.sample.screen.navigation.feature.navigation.MainNavigationRouter
import ru.endroad.sample.screen.navigation.router.routers.HubRouterImpl
import ru.endroad.sample.screen.navigation.router.routers.MainNavigationRouterImpl

val moduleRouters = module {
	singleBy<HubRouter, HubRouterImpl>()
	singleBy<MainNavigationRouter, MainNavigationRouterImpl>()
}