package ru.endroad.sample.screen.navigation.feature.colored.red

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.koin.java.KoinJavaComponent
import ru.endroad.sample.screen.navigation.feature.colored.ColoredView
import ru.endroad.sample.screen.navigation.router.navigator.NavigationManager
import ru.endroad.sample.screen.navigation.router.navigator.stackState
import ru.endroad.sample.screen.navigation.utils.Scene

class RedScene : Scene() {

	private val navigationManager by KoinJavaComponent.inject(NavigationManager::class.java)

	@Composable
	override fun RenderScreen() = ColoredView(
		sceneName = navigationManager.stackState(),
		color = Color.Red,
		replaceScene = null,
		openScene = null,
	)
}