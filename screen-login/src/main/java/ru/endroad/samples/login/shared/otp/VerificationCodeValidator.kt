package ru.endroad.samples.login.shared.otp

class VerificationCodeValidator {

	private companion object {
		const val VERIFICATION_CODE_LENGTH = 6
	}

	fun validate(code: String): Boolean =
		code.length == VERIFICATION_CODE_LENGTH
}