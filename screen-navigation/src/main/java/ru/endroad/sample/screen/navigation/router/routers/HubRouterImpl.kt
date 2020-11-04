package ru.endroad.sample.screen.navigation.router.routers

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.application.HubRouter
import ru.endroad.sample.screen.navigation.feature.navigation.MainNavigationDestination
import ru.endroad.sample.screen.navigation.router.di.rootNavigatorQualifier
import ru.endroad.sample.screen.navigation.router.navigator.Navigator

class HubRouterImpl : HubRouter {

	private val rootNavigator by inject(Navigator::class.java, rootNavigatorQualifier)

	override fun openMainScreen() {
		rootNavigator.changeRoot(MainNavigationDestination(R.id.navigation_colored))
	}
}