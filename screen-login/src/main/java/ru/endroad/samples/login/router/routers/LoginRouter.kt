package ru.endroad.samples.login.router.routers

import ru.endroad.samples.login.application.StubFragment
import ru.endroad.samples.login.router.navigator.Navigator
import ru.endroad.samples.login.view.LoginComposeFragment

class LoginRouter(private val navigatorHolder: Navigator) {

	fun openLoginScreen() {
		navigatorHolder.changeRoot(LoginComposeFragment())
	}

	fun openMainScreen() {
		navigatorHolder.changeRoot(StubFragment())
	}

	fun openErrorScreen(message: String) {
		navigatorHolder.openNoticeAlertDialog(message)
	}
}