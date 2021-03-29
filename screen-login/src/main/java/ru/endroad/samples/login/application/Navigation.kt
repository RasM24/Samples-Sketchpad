package ru.endroad.samples.login.application

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import ru.endroad.samples.login.experiment.Scene
import ru.endroad.samples.login.view.RenderStubView

class NavigationViewModel : ViewModel() {

	private val initialScene = object : Scene() {
		@Composable
		override fun RenderScreen() = RenderStubView()
	}

	var currentScreen: MutableStateFlow<Scene> = MutableStateFlow(initialScene)
}
