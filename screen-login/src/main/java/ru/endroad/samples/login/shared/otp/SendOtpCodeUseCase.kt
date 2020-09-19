package ru.endroad.samples.login.shared.otp

class SendOtpCodeUseCase(private val otpDataSource: OtpDataSource) {

	suspend operator fun invoke(phone: String) =
		otpDataSource.sendOtp(phone)
}