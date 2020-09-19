package ru.endroad.samples.login.error

sealed class DomainError(message: String) : RuntimeException(message) {

	class Unauthorized(message: String) : DomainError(message)
	class WrongOtp(message: String) : DomainError(message)
	class TimeExpiredOtp(message: String) : DomainError(message)
}