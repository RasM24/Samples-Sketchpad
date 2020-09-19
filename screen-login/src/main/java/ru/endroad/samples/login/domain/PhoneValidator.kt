package ru.endroad.samples.login.domain

class PhoneValidator {

	private companion object {
		const val PHONE_LENGTH = 12
	}

	fun validate(phone: String): Boolean =
		phone.length == PHONE_LENGTH
}