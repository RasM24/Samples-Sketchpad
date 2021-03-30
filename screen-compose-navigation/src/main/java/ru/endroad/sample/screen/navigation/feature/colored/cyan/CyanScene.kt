package ru.endroad.sample.screen.navigation.feature.colored.cyan

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter
import ru.endroad.sample.screen.navigation.feature.colored.ColoredView
import ru.endroad.sample.screen.navigation.utils.Scene

class CyanScene : Scene() {

	private val router by inject(ColoredRouter::class.java)

	@Composable
	override fun RenderScreen() = ColoredView(
		//TODO
		// sceneName = this.getBackStackStringFormatted(),
		sceneName = "UNAVAILABLE",
		color = Color.Cyan,
		replaceScene = router::replaceBlueScreen,
		openScene = router::openBlueScreen,
	)
}