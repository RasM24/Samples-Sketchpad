package ru.endroad.samples.login.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.endroad.libraries.mvi.core.viewmodel.PresenterMvi

class LoginViewModel : PresenterMvi<LoginScreenState, LoginScreenEvent>, ViewModel() {

	override val state = MutableLiveData<LoginScreenState>().apply {
		value = LoginScreenState.Initialized(false)
	}

	override fun reduce(event: LoginScreenEvent) {
		when (event) {
			LoginScreenEvent.ClickFacebookSign    -> TODO()
			LoginScreenEvent.ClickGoogleSign      -> TODO()
			LoginScreenEvent.ClickVkontakteSign   -> TODO()
			is LoginScreenEvent.ClickSendOtpCode  -> TODO()
			is LoginScreenEvent.ClickCheckOtpCode -> TODO()
			is LoginScreenEvent.ClickResendCode   -> TODO()
			is LoginScreenEvent.ChangeCode        -> TODO()
			is LoginScreenEvent.ChangePhone       -> TODO()
		}
	}
}