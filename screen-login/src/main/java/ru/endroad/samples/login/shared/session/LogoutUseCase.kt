package ru.endroad.samples.login.shared.session

class LogoutUseCase(private val sessionDataSource: SessionDataSource) {

	operator fun invoke() {
		sessionDataSource.set(null)
	}
}