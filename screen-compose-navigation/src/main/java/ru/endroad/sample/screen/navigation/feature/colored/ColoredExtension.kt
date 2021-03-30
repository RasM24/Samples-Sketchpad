package ru.endroad.sample.screen.navigation.feature.colored

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import ru.endroad.sample.screen.navigation.R

fun Fragment.getBackStackStringFormatted(): String =
	buildString {
		appendLine("backStack:")
		for (i in 0 until parentFragmentManager.backStackEntryCount) {
			appendLine(parentFragmentManager.getBackStackEntryAt(i).name)
		}
	}

@Composable
fun ColoredView(sceneName: String, color: Color, replaceScene: (() -> Unit)?, openScene: (() -> Unit)?) = Surface(color = color) {
	Column(Modifier.padding(16.dp)) {
		Text(modifier = Modifier.padding(vertical = 8.dp), text = sceneName)
		replaceScene?.let {
			Button(modifier = Modifier
				.fillMaxWidth()
				.padding(vertical = 8.dp), onClick = replaceScene) {
				Text(text = stringResource(id = R.string.colored_replace_button))
			}
		}
		openScene?.let {
			Button(modifier = Modifier
				.fillMaxWidth()
				.padding(vertical = 8.dp), onClick = openScene) {
				Text(text = stringResource(id = R.string.colored_open_button))
			}
		}
	}
}