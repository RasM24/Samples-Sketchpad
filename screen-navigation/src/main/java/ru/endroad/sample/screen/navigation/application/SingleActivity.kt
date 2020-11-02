package ru.endroad.sample.screen.navigation.application

import android.os.Bundle
import org.koin.android.ext.android.inject
import ru.endroad.libraries.camp.activity.CampActivity
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.router.navigator.NavigatorHolder

class SingleActivity : CampActivity() {

	override val layout = R.layout.root_activity
	override val theme = R.style.ThemeSketchpad

	private val navigatorHolder: NavigatorHolder by inject()

	override fun onCreate(savedInstanceState: Bundle?) {
		navigatorHolder.hubActivity = this
		super.onCreate(savedInstanceState)
	}

	override fun onDestroy() {
		navigatorHolder.hubActivity = null
		super.onDestroy()
	}
}