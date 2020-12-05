package ru.endroad.sample.screen.navigation.router.routers

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter
import ru.endroad.sample.screen.navigation.feature.colored.blue.BlueDestination
import ru.endroad.sample.screen.navigation.feature.colored.cyan.CyanDestination
import ru.endroad.sample.screen.navigation.feature.colored.green.GreenDestination
import ru.endroad.sample.screen.navigation.feature.colored.magenta.MagentaDestination
import ru.endroad.sample.screen.navigation.feature.colored.red.RedDestination
import ru.endroad.sample.screen.navigation.router.command.Command
import ru.endroad.sample.screen.navigation.router.di.contentNavigatorQualifier
import ru.endroad.sample.screen.navigation.router.navigator.Navigator

class ColoredRouterImpl : ColoredRouter {

	private val contentNavigator: Navigator by inject(Navigator::class.java, contentNavigatorQualifier)

	override fun openRedScreen() {
		contentNavigator.execute(Command.Open(RedDestination))
	}

	override fun replaceRedScreen() {
		contentNavigator.execute(Command.Replace(RedDestination))
	}

	override fun openMagentaScreen() {
		contentNavigator.execute(Command.Open(MagentaDestination))
	}

	override fun replaceMagentaScreen() {
		contentNavigator.execute(Command.Replace(MagentaDestination))
	}

	override fun openGreenScreen() {
		contentNavigator.execute(Command.Open(GreenDestination))
	}

	override fun replaceGreenScreen() {
		contentNavigator.execute(Command.Replace(GreenDestination))
	}

	override fun openCyanScreen() {
		contentNavigator.execute(Command.Open(CyanDestination))
	}

	override fun replaceCyanScreen() {
		contentNavigator.execute(Command.Replace(CyanDestination))
	}

	override fun openBlueScreen() {
		contentNavigator.execute(Command.Open(BlueDestination))
	}

	override fun replaceBlueScreen() {
		contentNavigator.execute(Command.Replace(BlueDestination))
	}
}