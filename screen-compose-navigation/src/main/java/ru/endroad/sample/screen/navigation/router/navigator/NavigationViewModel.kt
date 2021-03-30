package ru.endroad.sample.screen.navigation.router.navigator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import ru.endroad.sample.screen.navigation.utils.Scene

class NavigationScenesStack : ViewModel() {

	private val initialScene = object : Scene() {
		@Composable
		override fun RenderScreen() = RenderStubView()
	}

	var currentScreen: MutableStateFlow<Scene> = MutableStateFlow(initialScene)
}

@Composable
internal fun RenderStubView() {
	Box(modifier = Modifier.fillMaxSize()) {
		Text(modifier = Modifier.align(Alignment.Center), text = "Здесь будет что-то") //TODO HardcodeText
	}
}