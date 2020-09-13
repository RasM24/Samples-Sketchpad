package ru.endroad.samples.login.application

import android.os.Bundle
import org.koin.android.ext.android.inject
import ru.endroad.libraries.camp.activity.CampActivity
import ru.endroad.samples.login.R
import ru.endroad.samples.login.router.navigator.Navigator
import ru.endroad.samples.login.router.routers.MainRouter

class SingleActivity : CampActivity() {

	override val layout = R.layout.hub_activity
	override val theme = R.style.AppTheme

	val navigator: Navigator by inject()
	val mainRouter: MainRouter by inject()

	override fun onCreate(savedInstanceState: Bundle?) {
		navigator.hubActivity = this
		super.onCreate(savedInstanceState)
	}

	override fun onDestroy() {
		navigator.hubActivity = null
		super.onDestroy()
	}

	override fun onFirstCreate() {
		mainRouter.openFirstScreen()
	}
}