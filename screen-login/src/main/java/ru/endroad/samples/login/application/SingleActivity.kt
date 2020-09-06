package ru.endroad.samples.login.application

import ru.endroad.libraries.camp.activity.CampActivity
import ru.endroad.navigation.changeRoot
import ru.endroad.samples.login.R
import ru.endroad.samples.login.view.LoginFragment

class SingleActivity : CampActivity() {

	override val layout = R.layout.hub_activity
	override val theme = R.style.AppTheme

	override fun onFirstCreate() {
		supportFragmentManager.changeRoot(LoginFragment(), R.id.root)
	}
}