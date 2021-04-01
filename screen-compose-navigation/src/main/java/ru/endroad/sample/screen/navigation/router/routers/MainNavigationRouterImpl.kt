package ru.endroad.sample.screen.navigation.router.routers

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.feature.alphabet.AlphabetDestination
import ru.endroad.sample.screen.navigation.feature.colored.colored.ColoredDestination
import ru.endroad.sample.screen.navigation.feature.external.fragment.ExternalLinksDestination
import ru.endroad.sample.screen.navigation.application.MainNavigationRouter
import ru.endroad.sample.screen.navigation.router.command.Command
import ru.endroad.sample.screen.navigation.router.di.contentNavigatorQualifier
import ru.endroad.sample.screen.navigation.router.navigator.Navigator

class MainNavigationRouterImpl : MainNavigationRouter {

	private val contentNavigator: Navigator by inject(Navigator::class.java, contentNavigatorQualifier)

	override fun openColoredScreen() {
		contentNavigator.execute(Command.ChangeRoot(ColoredDestination))
	}

	override fun openAlphabetScreen() {
		contentNavigator.execute(Command.ChangeRoot(AlphabetDestination))
	}

	override fun openExternalLinksScreen() {
		contentNavigator.execute(Command.ChangeRoot(ExternalLinksDestination))
	}
}