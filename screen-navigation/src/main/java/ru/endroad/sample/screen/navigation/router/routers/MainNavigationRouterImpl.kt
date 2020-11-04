package ru.endroad.sample.screen.navigation.router.routers

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.feature.alphabet.AlphabetDestination
import ru.endroad.sample.screen.navigation.feature.colored.colored.ColoredDestination
import ru.endroad.sample.screen.navigation.feature.external.fragment.ExternalLinksDestination
import ru.endroad.sample.screen.navigation.feature.navigation.MainNavigationRouter
import ru.endroad.sample.screen.navigation.router.di.contentNavigatorQualifier
import ru.endroad.sample.screen.navigation.router.navigator.Navigator

class MainNavigationRouterImpl : MainNavigationRouter {

	private val contentNavigator: Navigator by inject(Navigator::class.java, contentNavigatorQualifier)

	override fun openColoredScreen() {
		contentNavigator.changeRoot(ColoredDestination)
	}

	override fun openAlphabetScreen() {
		contentNavigator.changeRoot(AlphabetDestination)
	}

	override fun openExternalLinksScreen() {
		contentNavigator.changeRoot(ExternalLinksDestination)
	}
}