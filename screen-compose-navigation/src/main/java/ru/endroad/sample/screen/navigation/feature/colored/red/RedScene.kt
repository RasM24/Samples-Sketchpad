package ru.endroad.sample.screen.navigation.feature.colored.red

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.endroad.sample.screen.navigation.feature.colored.ColoredView
import ru.endroad.sample.screen.navigation.utils.Scene

class RedScene : Scene() {

	@Composable
	override fun RenderScreen() = ColoredView(
		//TODO
		// sceneName = this.getBackStackStringFormatted(),
		sceneName = "UNAVAILABLE",
		color = Color.Red,
		replaceScene = null,
		openScene = null,
	)
}