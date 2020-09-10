package ru.endroad.samples.login.shared.otp

import org.koin.dsl.module
import org.koin.experimental.builder.single
import org.koin.experimental.builder.singleBy

val moduleShareOtp = module {
	singleBy<OtpDataSource, OtpMockDataSource>()
	singleBy<NotificationService, OtpNotificationService>()

	single<SendOtpCodeUseCase>()
	single<CheckOtpCodeUseCase>()
	single<VerificationCodeValidator>()
}