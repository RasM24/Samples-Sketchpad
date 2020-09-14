package ru.endroad.samples.login.shared.otp

import ru.endroad.samples.login.shared.otp.OtpCodeGenerator.Companion.MAX_CODE
import ru.endroad.samples.login.shared.otp.OtpCodeGenerator.Companion.MIN_CODE
import kotlin.random.Random

interface OtpCodeGenerator {

	companion object {
		const val MIN_CODE = 100_000
		const val MAX_CODE = 999_999
	}

	fun generate(): String
}

class RandomOtpCodeGenerator : OtpCodeGenerator {
	override fun generate(): String =
		Random.nextInt(MIN_CODE, MAX_CODE).toString()
}