package ru.endroad.samples.login.shared.otp

class CheckOtpCodeUseCase(private val otpDataSource: OtpDataSource) {

	suspend operator fun invoke(verificationCode: String): Credential =
		otpDataSource.checkOtp(verificationCode)
}