package ru.endroad.samples.login.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.endroad.component.core.MviViewModel
import ru.endroad.samples.login.error.DomainError
import ru.endroad.samples.login.router.routers.LoginRouter
import ru.endroad.samples.login.shared.otp.CheckOtpCodeUseCase
import ru.endroad.samples.login.shared.otp.SendOtpCodeUseCase
import ru.endroad.samples.login.shared.session.CreateSessionUseCase
import ru.endroad.samples.login.shared.session.Session
import ru.endroad.samples.login.shared.social.SignWithFacebookUseCase
import ru.endroad.samples.login.shared.social.SignWithGoogleUseCase
import ru.endroad.samples.login.shared.social.SignWithVkontakteUseCase

class LoginViewModel(
	private val sendOtpCode: SendOtpCodeUseCase,
	private val checkOtpCode: CheckOtpCodeUseCase,
	private val createSession: CreateSessionUseCase,
	private val signWithFacebook: SignWithFacebookUseCase,
	private val signWithGoogle: SignWithGoogleUseCase,
	private val signWithVkontakte: SignWithVkontakteUseCase,
	private val router: LoginRouter
) : MviViewModel<LoginScreenState, LoginScreenEvent>, ViewModel() {

	override val state = MutableStateFlow<LoginScreenState>(LoginScreenState.Initialized(""))

	override fun notice(event: LoginScreenEvent) {
		viewModelScope.launch(exceptionHandler) {
			when (event) {
				LoginScreenEvent.ClickFacebookSign  -> successLogin(signWithFacebook().token)
				LoginScreenEvent.ClickGoogleSign    -> successLogin(signWithGoogle().token)
				LoginScreenEvent.ClickVkontakteSign -> successLogin(signWithVkontakte().token)
				LoginScreenEvent.ClickCheckOtpCode  -> checkOtpCode((state.value as LoginScreenState.VerifyCode).code).token.let(::successLogin)
				LoginScreenEvent.ClickSendOtpCode   -> sendCode(state.value.phone).let(state::tryEmit)
				LoginScreenEvent.ClickResendCode    -> sendCode(state.value.phone).let(state::tryEmit)
				else                                -> reduce(state.value, event).let(state::tryEmit)
			}
		}
	}

	private val reduce: (LoginScreenState, LoginScreenEvent) -> LoginScreenState = { currentState, event ->
		when (event) {
			is LoginScreenEvent.ChangeCode -> (currentState as LoginScreenState.VerifyCode).copy(code = event.code)
			is LoginScreenEvent.ChangePhone -> LoginScreenState.Initialized(phone = event.phone)
			else -> throw IllegalStateException()
		}
	}

	private suspend fun sendCode(phone: String): LoginScreenState {
		sendOtpCode(phone)
		return LoginScreenState.VerifyCode(phone, "")
	}

	private fun successLogin(token: String) {
		createSession(Session(token))
		router.openMainScreen()
	}

	private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
		when (exception) {
			is DomainError.WrongOtp     -> router.openErrorScreen(exception.message ?: "")
			is DomainError.Unauthorized -> router.openErrorScreen(exception.message ?: "")
			else                        -> Log.e("LoginScreen", exception.message ?: "")
		}
	}
}