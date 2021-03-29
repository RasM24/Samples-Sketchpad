package ru.endroad.samples.login.application

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.endroad.samples.login.R
import ru.endroad.samples.login.experiment.Scene
import ru.endroad.samples.login.experiment.inject
import ru.endroad.samples.login.router.routers.LoginRouter
import ru.endroad.samples.login.shared.session.LogoutUseCase

//TODO заполнить экран данными для имитации входа в приложение
class StubFragment : Scene() {

	private val loginRouter: LoginRouter by inject()
	private val logoutUseCase: LogoutUseCase by inject()

	@Composable
	override fun RenderScreen() =
		Box(modifier = Modifier.fillMaxSize()) {
			Button(modifier = Modifier.align(Alignment.Center), onClick = ::logout) {
				Text(text = stringResource(id = R.string.logout_button))
			}
		}

	private fun logout() {
		logoutUseCase()
		loginRouter.openLoginScreen()
	}
}