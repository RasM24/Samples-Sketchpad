package ru.endroad.samples.login.view

sealed class LoginScreenState {

	abstract val phone: String

	data class Initialized(override val phone: String) : LoginScreenState()
	data class VerifyCode(override val phone: String, val code: String) : LoginScreenState()
}