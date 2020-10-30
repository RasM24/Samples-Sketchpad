package ru.endroad.samples.screen.game.application

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.hub_activity.*
import ru.endroad.libraries.camp.activity.CampActivity
import ru.endroad.samples.screen.game.R

class SingleActivity : CampActivity() {

	override val layout = R.layout.hub_activity
	override val theme = R.style.ThemeSketchpad

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setupToolbar()
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
}