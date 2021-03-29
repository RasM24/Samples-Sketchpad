package ru.endroad.samples.login.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import ru.endroad.samples.login.experiment.Scene
import ru.endroad.samples.login.experiment.inject

class LoginComposeFragment : Scene() {

	private val viewModel: LoginViewModel by inject()

	@Composable
	override fun RenderScreen() = viewModel.state.collectAsState().value.RenderUI()
}