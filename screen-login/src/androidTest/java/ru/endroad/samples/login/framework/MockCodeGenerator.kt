package ru.endroad.samples.login.framework

import ru.endroad.samples.login.shared.otp.OtpCodeGenerator

class MockCodeGenerator(private val mockCode: String) : OtpCodeGenerator {
	override fun generate(): String = mockCode
}