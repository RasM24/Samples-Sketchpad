package ru.endroad.samples.screen.game.application

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.hub_activity.*
import org.koin.android.ext.android.inject
import ru.endroad.component.core.CampActivity
import ru.endroad.samples.screen.game.R
import ru.endroad.samples.screen.game.router.navigator.Navigator
import ru.endroad.samples.screen.game.router.routers.MainRouter

class SingleActivity : CampActivity() {

	override val layout = R.layout.hub_activity
	override val theme = R.style.ThemeSketchpad

	private val navigator: Navigator by inject()
	private val router: MainRouter by inject()

	override fun onCreate(savedInstanceState: Bundle?) {
		navigator.hubActivity = this
		super.onCreate(savedInstanceState)
		setupToolbar()
	}

	override fun onDestroy() {
		navigator.hubActivity = null
		super.onDestroy()
	}

	private fun setupToolbar() {
		setSupportActionBar(toolbar)
		toolbar.setNavigationOnClickListener { onBackPressed() }
		supportFragmentManager.addOnBackStackChangedListener {
			supportActionBar?.setHomeEnabled()
		}
		supportActionBar?.setHomeEnabled()
	}

	private fun ActionBar.setHomeEnabled() {
		this.setDisplayHomeAsUpEnabled(supportFragmentManager.backStackEntryCount != 0)
	}

	override fun onFirstCreate() {
		router.openMenu()
	}
}