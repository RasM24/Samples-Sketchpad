package ru.endroad.sample.screen.navigation.feature.colored.colored

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter
import ru.endroad.sample.screen.navigation.feature.colored.ColoredView
import ru.endroad.sample.screen.navigation.utils.Scene

class ColoredScene : Scene() {

	private val router by inject(ColoredRouter::class.java)

	//TODO
	// requireActivity().title = getString(R.string.title_colored)

	@Composable
	override fun RenderScreen() = ColoredView(
		//TODO
		// sceneName = this.getBackStackStringFormatted(),
		sceneName = "UNAVAILABLE",
		color = Color.LightGray,
		replaceScene = null,
		openScene = router::openGreenScreen,
	)
}