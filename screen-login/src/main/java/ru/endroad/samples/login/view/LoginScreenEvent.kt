package ru.endroad.samples.login.view

sealed class LoginScreenEvent {
	object ClickFacebookSign : LoginScreenEvent()
	object ClickGoogleSign : LoginScreenEvent()
	object ClickVkontakteSign : LoginScreenEvent()
	object ClickSendOtpCode : LoginScreenEvent()
	object ClickCheckOtpCode : LoginScreenEvent()
	object ClickResendCode : LoginScreenEvent()
	class ChangeCode(val code: String) : LoginScreenEvent()
	class ChangePhone(val phone: String) : LoginScreenEvent()
}