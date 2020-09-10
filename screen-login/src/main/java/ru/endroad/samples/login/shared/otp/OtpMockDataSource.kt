package ru.endroad.samples.login.shared.otp

import kotlinx.coroutines.*
import kotlin.random.Random

interface OtpDataSource {
	suspend fun sendOtp(phone: String)
	suspend fun checkOtp(code: String): Credential
	fun timeLastSendingOtp(): Long?
}

class OtpMockDataSource(
	private val notificationService: NotificationService
) : OtpDataSource {

	private companion object {
		const val MIN_CODE = 100_000
		const val MAX_CODE = 999_999
		const val CODE_LIFETIME_IN_MILLIS = 20000L
		const val MOCK_USER_TOKEN = "Go4rMeygtsZb8rvbxnzA"
	}

	private var verificationCode: String? = null
	private var lastTimeGenerateCode: Long? = null

	private val randomCode: String get() = Random.nextInt(MIN_CODE, MAX_CODE).toString()

	override suspend fun sendOtp(phone: String) {
		generateExpiringCode()
		verificationCode?.let(notificationService::sendPush)
		lastTimeGenerateCode = System.currentTimeMillis()
	}

	private fun generateExpiringCode() {
		verificationCode = randomCode
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
			throw RuntimeException("Ошибка авторизации") //TODO доработать в задаче с обработкой ошибок
		}
	}

	override fun timeLastSendingOtp(): Long? =
		lastTimeGenerateCode

}