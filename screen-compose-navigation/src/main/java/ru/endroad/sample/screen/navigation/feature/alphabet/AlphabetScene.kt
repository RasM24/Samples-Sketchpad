package ru.endroad.sample.screen.navigation.feature.alphabet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.utils.Scene

class AlphabetScene : Scene() {
	//TODO
	// requireActivity().title = getString(R.string.title_alphabet)

	@Composable
	override fun RenderScreen() =
		Box(modifier = Modifier.fillMaxSize()) {
			Text(text = stringResource(id = R.string.alphabet_stub_text))
		}
}