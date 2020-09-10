package ru.endroad.samples.login.shared.session

class CreateSessionUseCase(private val sessionDataSource: SessionDataSource) {

	operator fun invoke(session: Session) {
		sessionDataSource.set(session)
	}
}