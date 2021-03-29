package ru.endroad.samples.login.application

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import ru.endroad.samples.login.R
import ru.endroad.samples.login.router.routers.LoginRouter
import ru.endroad.samples.login.shared.session.LogoutUseCase

//TODO заполнить экран данными для имитации входа в приложение
class StubFragment : Fragment() {

	private val loginRouter: LoginRouter by inject()
	private val logoutUseCase by inject<LogoutUseCase>()


	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			setContent {
				MaterialTheme {
					Scaffold {
						Box(modifier = Modifier.fillMaxSize()) {
							Button(modifier = Modifier.align(Alignment.Center), onClick = ::logout) {
								Text(text = stringResource(id = R.string.logout_button))
							}
						}
					}
				}
			}
		}

	private fun logout() {
		logoutUseCase()
		loginRouter.openLoginScreen()
	}
}