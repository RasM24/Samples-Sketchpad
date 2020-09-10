package ru.endroad.samples.login.shared.otp

import org.koin.dsl.module
import org.koin.experimental.builder.single

val moduleShareOtp = module {
	single<SendOtpCodeUseCase>()
	single<CheckOtpCodeUseCase>()
	single<VerificationCodeValidator>()
}