package ru.endroad.sample.screen.navigation.router.navigator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.endroad.sample.screen.navigation.utils.Scene

class NavigationManager {

	@Deprecated("разобраться с первым фрагментов")
	private val initialScene = object : Scene() {

		@Composable
		override fun getTitle() = "Stub Scene"

		@Composable
		override fun RenderScreen() = RenderStubView()
	}

	var stackScenes: MutableList<Scene> = mutableListOf(initialScene)
		private set

	private val _currentScreen: MutableStateFlow<Scene> = MutableStateFlow(initialScene)
	val currentScreen: StateFlow<Scene> = _currentScreen

	fun changeStack(scene: Scene) {
		stackScenes = mutableListOf(scene)
		_currentScreen.tryEmit(scene)
	}

	fun openScreen(scene: Scene) {
		stackScenes.add(scene)
		_currentScreen.tryEmit(scene)
	}

	fun replaceScreen(scene: Scene) {
		stackScenes.removeLast()
		stackScenes.add(scene)
		_currentScreen.tryEmit(scene)
	}

	fun back(): Boolean {
		return if (stackScenes.size > 1) {
			stackScenes.removeLast()
			_currentScreen.tryEmit(stackScenes.last())
			true
		} else {
			false
		}
	}
}

fun NavigationManager.stackState() = buildString {
	appendLine("navigation stack:")
	stackScenes.forEachIndexed { index, scene ->
		if (index == stackScenes.lastIndex) append("-> ")
		appendLine(scene::class.simpleName)
	}
}

@Composable
internal fun RenderStubView() {
	Box(modifier = Modifier.fillMaxSize()) {
		Text(modifier = Modifier.align(Alignment.Center), text = "Здесь будет что-то") //TODO HardcodeText
	}
}