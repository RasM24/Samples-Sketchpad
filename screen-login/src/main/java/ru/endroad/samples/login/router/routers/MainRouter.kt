package ru.endroad.samples.login.router.routers

import ru.endroad.samples.login.application.StubFragment
import ru.endroad.samples.login.router.navigator.Navigator
import ru.endroad.samples.login.shared.session.IsAuthorizedUseCase
import ru.endroad.samples.login.view.LoginFragment

class MainRouter(
	private val isAuthorized: IsAuthorizedUseCase,
	private val navigatorHolder: Navigator
) {

	fun openFirstScreen() {
		if (isAuthorized()) {
			navigatorHolder.changeRoot(StubFragment())
		} else {
			navigatorHolder.changeRoot(LoginFragment())
		}
	}
}