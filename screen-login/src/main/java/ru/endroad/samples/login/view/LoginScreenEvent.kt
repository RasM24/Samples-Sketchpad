package ru.endroad.samples.login.view

sealed class LoginScreenEvent {
	object ClickFacebookSign : LoginScreenEvent()
	object ClickGoogleSign : LoginScreenEvent()
	object ClickVkontakteSign : LoginScreenEvent()
	class ClickSendOtpCode(val phone: String) : LoginScreenEvent()
	class ClickCheckOtpCode(val code: String) : LoginScreenEvent()
	class ClickResendCode(val phone: String) : LoginScreenEvent()
	class ChangeCode(val code: String) : LoginScreenEvent()
	class ChangePhone(val phone: String) : LoginScreenEvent()
}