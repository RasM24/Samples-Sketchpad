package ru.endroad.samples.login.shared.otp

import kotlinx.coroutines.*
import ru.endroad.samples.login.error.DomainError

interface OtpDataSource {
	suspend fun sendOtp(phone: String)
	suspend fun checkOtp(code: String): Credential
	fun timeLastSendingOtp(): Long?
}

class OtpMockDataSource(
	private val notificationService: NotificationService,
	private val otpCodeGenerator: OtpCodeGenerator
) : OtpDataSource {

	private companion object {
		const val CODE_LIFETIME_IN_MILLIS = 20000L
		const val MOCK_USER_TOKEN = "Go4rMeygtsZb8rvbxnzA"
	}

	private var verificationCode: String? = null
	private var lastTimeGenerateCode: Long? = null

	override suspend fun sendOtp(phone: String) {
		generateExpiringCode()
		verificationCode?.let(notificationService::sendPush)
		lastTimeGenerateCode = System.currentTimeMillis()
	}

	private fun generateExpiringCode() {
		verificationCode = otpCodeGenerator.generate()
		CoroutineScope(Dispatchers.IO).launch {
			delay(CODE_LIFETIME_IN_MILLIS)
			verificationCode = null
			lastTimeGenerateCode = null
		}
	}

	override suspend fun checkOtp(code: String): Credential {
		if (code == verificationCode) {
			return Credential(MOCK_USER_TOKEN)
		} else {
			throw DomainError.WrongOtp("Введен неверный код верификации")
		}
	}

	override fun timeLastSendingOtp(): Long? =
		lastTimeGenerateCode

}