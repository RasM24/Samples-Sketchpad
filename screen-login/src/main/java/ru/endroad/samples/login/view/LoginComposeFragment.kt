package ru.endroad.samples.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.StateFlow
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginComposeFragment : Fragment() {

	private val viewModel: LoginViewModel by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			setContent {
				App(viewModel.state)
			}
		}

	@Composable
	fun App(stateFlow: StateFlow<LoginScreenState>) {
		MaterialTheme {
			Scaffold {
				when (val state = stateFlow.collectAsState().value) {
					is LoginScreenState.Initialized -> InitializedStateScreen(
						state,
						onChangeText = { viewModel.notice(LoginScreenEvent.ChangePhone(it)) },
						onSendOtpCode = { viewModel.notice(LoginScreenEvent.ClickSendOtpCode) },
						onFbSignClick = { viewModel.notice(LoginScreenEvent.ClickFacebookSign) },
						onVkSignClick = { viewModel.notice(LoginScreenEvent.ClickVkontakteSign) },
						onGoogleSignClick = { viewModel.notice(LoginScreenEvent.ClickGoogleSign) },
					)
					is LoginScreenState.VerifyCode  -> RenderStubView()
				}
			}
		}
	}
}