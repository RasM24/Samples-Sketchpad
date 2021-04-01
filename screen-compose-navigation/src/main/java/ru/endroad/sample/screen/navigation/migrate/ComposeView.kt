package ru.endroad.sample.screen.navigation.migrate

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

fun Fragment.composeFragmentView(content: @Composable () -> Unit) = ComposeView(requireContext()).apply {
	setContent {
		MaterialTheme {
			content()
		}
	}
}
