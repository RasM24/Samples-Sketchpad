package ru.endroad.sample.screen.navigation.router.routers

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter
import ru.endroad.sample.screen.navigation.feature.colored.blue.BlueDestination
import ru.endroad.sample.screen.navigation.feature.colored.cyan.CyanDestination
import ru.endroad.sample.screen.navigation.feature.colored.green.GreenDestination
import ru.endroad.sample.screen.navigation.feature.colored.magenta.MagentaDestination
import ru.endroad.sample.screen.navigation.feature.colored.red.RedDestination
import ru.endroad.sample.screen.navigation.router.command.Command
import ru.endroad.sample.screen.navigation.router.navigator.Navigator

class ColoredRouterImpl : ColoredRouter {

	private val navigator by inject(Navigator::class.java)

	override fun openRedScreen() {
		navigator.execute(Command.Open(RedDestination))
	}

	override fun replaceRedScreen() {
		navigator.execute(Command.Replace(RedDestination))
	}

	override fun openMagentaScreen() {
		navigator.execute(Command.Open(MagentaDestination))
	}

	override fun replaceMagentaScreen() {
		navigator.execute(Command.Replace(MagentaDestination))
	}

	override fun openGreenScreen() {
		navigator.execute(Command.Open(GreenDestination))
	}

	override fun replaceGreenScreen() {
		navigator.execute(Command.Replace(GreenDestination))
	}

	override fun openCyanScreen() {
		navigator.execute(Command.Open(CyanDestination))
	}

	override fun replaceCyanScreen() {
		navigator.execute(Command.Replace(CyanDestination))
	}

	override fun openBlueScreen() {
		navigator.execute(Command.Open(BlueDestination))
	}

	override fun replaceBlueScreen() {
		navigator.execute(Command.Replace(BlueDestination))
	}
}