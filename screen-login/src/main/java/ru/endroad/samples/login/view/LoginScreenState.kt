package ru.endroad.samples.login.view

import androidx.compose.runtime.Composable

sealed class LoginScreenState {

	abstract val phone: String

	abstract val notice: (LoginScreenEvent) -> Unit

	@Composable
	abstract fun RenderUI()

	data class Initialized(override val phone: String, override val notice: (LoginScreenEvent) -> Unit) : LoginScreenState() {

		@Composable
		override fun RenderUI() = InitializedStateScreen(
			phone = phone,
			onChangeText = { notice(LoginScreenEvent.ChangePhone(it)) },
			onSendOtpCode = { notice(LoginScreenEvent.ClickSendOtpCode) },
			onFbSignClick = { notice(LoginScreenEvent.ClickFacebookSign) },
			onVkSignClick = { notice(LoginScreenEvent.ClickVkontakteSign) },
			onGoogleSignClick = { notice(LoginScreenEvent.ClickGoogleSign) },
		)
	}

	data class VerifyCode(override val phone: String, val code: String, override val notice: (LoginScreenEvent) -> Unit) : LoginScreenState() {

		@Composable
		override fun RenderUI() = VerifyCodeStateScreen(
			phone = phone,
			code = code,
			changePhone = { notice(LoginScreenEvent.ChangePhone(it)) },
			changeCode = { notice(LoginScreenEvent.ChangeCode(it)) },
			checkOtpCode = { notice(LoginScreenEvent.ClickCheckOtpCode) },
			resendOtpCode = { notice(LoginScreenEvent.ClickResendCode) },
			onFbSignClick = { notice(LoginScreenEvent.ClickFacebookSign) },
			onVkSignClick = { notice(LoginScreenEvent.ClickVkontakteSign) },
			onGoogleSignClick = { notice(LoginScreenEvent.ClickGoogleSign) },
		)
	}
}