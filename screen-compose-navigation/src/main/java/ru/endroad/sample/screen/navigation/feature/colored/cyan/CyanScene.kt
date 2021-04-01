package ru.endroad.sample.screen.navigation.feature.colored.cyan

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter
import ru.endroad.sample.screen.navigation.feature.colored.ColoredView
import ru.endroad.sample.screen.navigation.router.navigator.NavigationManager
import ru.endroad.sample.screen.navigation.router.navigator.stackState
import ru.endroad.sample.screen.navigation.utils.Scene

class CyanScene : Scene() {

	private val router by inject(ColoredRouter::class.java)
	private val navigationManager by inject(NavigationManager::class.java)

	@Composable
	override fun getTitle() = stringResource(id = R.string.title_colored)

	@Composable
	override fun RenderScreen() = ColoredView(
		sceneName = navigationManager.stackState(),
		color = Color.Cyan,
		replaceScene = router::replaceBlueScreen,
		openScene = router::openBlueScreen,
	)
}