package ru.endroad.samples.login.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.endroad.libraries.mvi.core.viewmodel.PresenterMvi
import ru.endroad.samples.login.shared.session.Session
import ru.endroad.samples.login.domain.*
import ru.endroad.samples.login.shared.otp.CheckOtpCodeUseCase
import ru.endroad.samples.login.shared.otp.SendOtpCodeUseCase
import ru.endroad.samples.login.shared.otp.VerificationCodeValidator
import ru.endroad.samples.login.shared.session.CreateSessionUseCase

//TODO Не хватает обработчика ошибок
class LoginViewModel(
	private val sendOtpCode: SendOtpCodeUseCase,
	private val checkOtpCode: CheckOtpCodeUseCase,
	private val createSession: CreateSessionUseCase,
	private val signWithFacebook: SignWithFacebookUseCase,
	private val signWithGoogle: SignWithGoogleUseCase,
	private val signWithVkontakte: SignWithVkontakteUseCase,
	private val phoneValidator: PhoneValidator,
	private val verificationCodeValidator: VerificationCodeValidator
) : PresenterMvi<LoginScreenState, LoginScreenEvent>, ViewModel() {

	override val state = MutableLiveData<LoginScreenState>().apply {
		value = LoginScreenState.Initialized(false)
	}

	override fun reduce(event: LoginScreenEvent) {
		viewModelScope.launch {
			when (event) {
				LoginScreenEvent.ClickFacebookSign    -> signWithFacebook()
				LoginScreenEvent.ClickGoogleSign      -> signWithGoogle()
				LoginScreenEvent.ClickVkontakteSign   -> signWithVkontakte()
				is LoginScreenEvent.ClickSendOtpCode  -> state.value = event.reduce()
				is LoginScreenEvent.ClickCheckOtpCode -> state.value = event.reduce()
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

	private suspend fun LoginScreenEvent.ClickCheckOtpCode.reduce(): LoginScreenState {
		val credential = checkOtpCode(code)
		createSession(Session(credential.token))
		return LoginScreenState.VerifySuccess()
	}

	private suspend fun LoginScreenEvent.ClickResendCode.reduce(): LoginScreenState {
		sendOtpCode(phone)
		return LoginScreenState.VerifyCode(isCodeValidate = false)
	}
}