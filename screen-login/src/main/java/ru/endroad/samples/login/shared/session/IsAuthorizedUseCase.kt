package ru.endroad.samples.login.shared.session

class IsAuthorizedUseCase(private val sessionDataSource: SessionDataSource) {

	operator fun invoke(): Boolean =
		sessionDataSource.get() != null
}