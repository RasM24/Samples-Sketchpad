package ru.endroad.samples.login.application

import org.koin.android.ext.android.inject
import ru.endroad.libraries.camp.activity.CampActivity
import ru.endroad.navigation.changeRoot
import ru.endroad.samples.login.R
import ru.endroad.samples.login.shared.session.IsAuthorizedUseCase
import ru.endroad.samples.login.view.LoginFragment

class SingleActivity : CampActivity() {

	override val layout = R.layout.hub_activity
	override val theme = R.style.AppTheme

	val isAuthorized: IsAuthorizedUseCase by inject()

	//TODO вынести код в router
	override fun onFirstCreate() {
		if (isAuthorized()) {
			supportFragmentManager.changeRoot(StubFragment(), R.id.root)//TODO вынести в router
		} else {
			supportFragmentManager.changeRoot(LoginFragment(), R.id.root)
		}
	}
}