package ru.endroad.sample.screen.navigation.router.di

import org.koin.dsl.module
import org.koin.experimental.builder.singleBy
import ru.endroad.sample.screen.navigation.application.HubRouter
import ru.endroad.sample.screen.navigation.router.routers.HubRouterImpl

val moduleRouters = module {
	singleBy<HubRouter, HubRouterImpl>()
}