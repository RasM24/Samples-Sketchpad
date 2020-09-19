package ru.endroad.samples.login.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.endroad.libraries.mvi.core.viewmodel.PresenterMvi
import ru.endroad.samples.login.domain.PhoneValidator
import ru.endroad.samples.login.error.DomainError
import ru.endroad.samples.login.router.routers.LoginRouter
import ru.endroad.samples.login.shared.otp.CheckOtpCodeUseCase
import ru.endroad.samples.login.shared.otp.SendOtpCodeUseCase
import ru.endroad.samples.login.shared.otp.VerificationCodeValidator
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
	private val phoneValidator: PhoneValidator,
	private val verificationCodeValidator: VerificationCodeValidator,
	private val router: LoginRouter
) : PresenterMvi<LoginScreenState, LoginScreenEvent>, ViewModel() {

	override val state = MutableLiveData<LoginScreenState>().apply {
		value = LoginScreenState.Initialized(false)
	}

	override fun reduce(event: LoginScreenEvent) {
		viewModelScope.launch(exceptionHandler) {
			when (event) {
				LoginScreenEvent.ClickFacebookSign    -> successLogin(signWithFacebook().token)
				LoginScreenEvent.ClickGoogleSign      -> successLogin(signWithGoogle().token)
				LoginScreenEvent.ClickVkontakteSign   -> successLogin(signWithVkontakte().token)
				is LoginScreenEvent.ClickSendOtpCode  -> state.value = event.reduce()
				is LoginScreenEvent.ClickCheckOtpCode -> event.reduce()
				is LoginScreenEvent.ClickResendCode   -> state.value = event.reduce()
				is LoginScreenEvent.ChangeCode        -> state.value = event.reduce()
				is LoginScreenEvent.ChangePhone       -> state.value = event.reduce()
			}
		}
	}

	private fun LoginScreenEvent.ChangeCode.reduce(): LoginScreenState {
		val codeValidate = verificationCodeValidator.validate(code)
		return LoginScreenState.VerifyCode(isCodeValidate = codeValidate)
	}

	private fun LoginScreenEvent.ChangePhone.reduce(): LoginScreenState {
		val phoneValidate = phoneValidator.validate(phone)
		return LoginScreenState.Initialized(isPhoneValidate = phoneValidate)
	}

	private suspend fun LoginScreenEvent.ClickSendOtpCode.reduce(): LoginScreenState {
		sendOtpCode(phone)
		return LoginScreenState.VerifyCode(isCodeValidate = false)
	}

	private suspend fun LoginScreenEvent.ClickCheckOtpCode.reduce() {
		val credential = checkOtpCode(code)
		successLogin(credential.token)
	}

	private suspend fun LoginScreenEvent.ClickResendCode.reduce(): LoginScreenState {
		sendOtpCode(phone)
		return LoginScreenState.VerifyCode(isCodeValidate = false)
	}

	private fun successLogin(token: String) {
		createSession(Session(token))
		router.openMainScreen()
	}

	val exceptionHandler = CoroutineExceptionHandler { _, exception ->
		when (exception) {
			is DomainError.WrongOtp     -> router.openErrorScreen(exception.message ?: "")
			is DomainError.Unauthorized -> router.openErrorScreen(exception.message ?: "")
			else                        -> Log.e("LoginScreen", exception.message ?: "")
		}
	}
}