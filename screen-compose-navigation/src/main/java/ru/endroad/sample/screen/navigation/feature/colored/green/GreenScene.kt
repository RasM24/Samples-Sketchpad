package ru.endroad.sample.screen.navigation.feature.colored.green

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.koin.java.KoinJavaComponent
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter
import ru.endroad.sample.screen.navigation.feature.colored.ColoredView
import ru.endroad.sample.screen.navigation.utils.Scene

class GreenScene : Scene() {

	private val router by KoinJavaComponent.inject(ColoredRouter::class.java)

	@Composable
	override fun RenderScreen() =
		ColoredView(
			//TODO
			// sceneName = this.getBackStackStringFormatted(),
			sceneName = "UNAVAILABLE",
			color = Color.Green,
			replaceScene = router::replaceCyanScreen,
			openScene = router::openCyanScreen,
		)
}