package ru.endroad.samples.login.view

sealed class LoginScreenState {
	class Initialized(val isPhoneValidate: Boolean) : LoginScreenState()
	class VerifyCode(val isCodeValidate: Boolean) : LoginScreenState()
	class VerifySuccess : LoginScreenState()
}