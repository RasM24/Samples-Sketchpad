package ru.endroad.sample.screen.navigation.feature.colored.blue

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.koin.java.KoinJavaComponent
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter
import ru.endroad.sample.screen.navigation.feature.colored.ColoredView
import ru.endroad.sample.screen.navigation.utils.Scene

class BlueScene : Scene() {

	private val router by KoinJavaComponent.inject(ColoredRouter::class.java)

	@Composable
	override fun RenderScreen() = ColoredView(
		//TODO
		// sceneName = this.getBackStackStringFormatted(),
		sceneName = "UNAVAILABLE",
		color = Color.Blue,
		replaceScene = router::replaceMagentaScreen,
		openScene = router::openMagentaScreen,
	)
}