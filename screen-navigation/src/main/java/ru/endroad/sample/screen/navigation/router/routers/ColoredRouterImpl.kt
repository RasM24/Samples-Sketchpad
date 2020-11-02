package ru.endroad.sample.screen.navigation.router.routers

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter
import ru.endroad.sample.screen.navigation.feature.colored.blue.BlueDestination
import ru.endroad.sample.screen.navigation.feature.colored.cyan.CyanDestination
import ru.endroad.sample.screen.navigation.feature.colored.green.GreenDestination
import ru.endroad.sample.screen.navigation.feature.colored.magenta.MagentaDestination
import ru.endroad.sample.screen.navigation.feature.colored.red.RedDestination
import ru.endroad.sample.screen.navigation.router.di.contentNavigatorQualifier
import ru.endroad.sample.screen.navigation.router.navigator.Navigator

class ColoredRouterImpl : ColoredRouter {

	private val contentNavigator: Navigator by inject(Navigator::class.java, contentNavigatorQualifier)

	override fun openRedScreen() {
		contentNavigator.open(RedDestination)
	}

	override fun replaceRedScreen() {
		contentNavigator.replace(RedDestination)
	}

	override fun openMagentaScreen() {
		contentNavigator.open(MagentaDestination)
	}

	override fun replaceMagentaScreen() {
		contentNavigator.replace(MagentaDestination)
	}

	override fun openGreenScreen() {
		contentNavigator.open(GreenDestination)
	}

	override fun replaceGreenScreen() {
		contentNavigator.replace(GreenDestination)
	}

	override fun openCyanScreen() {
		contentNavigator.open(CyanDestination)
	}

	override fun replaceCyanScreen() {
		contentNavigator.replace(CyanDestination)
	}

	override fun openBlueScreen() {
		contentNavigator.open(BlueDestination)
	}

	override fun replaceBlueScreen() {
		contentNavigator.replace(BlueDestination)
	}
}