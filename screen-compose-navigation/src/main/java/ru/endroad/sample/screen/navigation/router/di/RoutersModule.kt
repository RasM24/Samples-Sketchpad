package ru.endroad.sample.screen.navigation.router.di

import org.koin.dsl.module
import org.koin.experimental.builder.singleBy
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter
import ru.endroad.sample.screen.navigation.feature.external.fragment.ExternalLinksRouter
import ru.endroad.sample.screen.navigation.application.MainNavigationRouter
import ru.endroad.sample.screen.navigation.router.routers.*

val moduleRouters = module {
	singleBy<MainNavigationRouter, MainNavigationRouterImpl>()
	singleBy<ColoredRouter, ColoredRouterImpl>()
	singleBy<ExternalLinksRouter, ExternalLinksRouterImpl>()
}