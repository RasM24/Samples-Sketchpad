package ru.endroad.sample.screen.navigation.feature.navigation

import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.main_navigation_fragment.*
import ru.endroad.libraries.camp.fragment.CampAppBarFragment
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.utils.withArguments

class MainNavigationFragment : CampAppBarFragment(), BottomNavigationView.OnNavigationItemSelectedListener {

	companion object {

		private const val INITIAL_SCREEN_KEY = "INITIAL_SCREEN"

		fun create(initialScreen: Int): Fragment =
			MainNavigationFragment().withArguments(
				INITIAL_SCREEN_KEY to initialScreen
			)
	}

	override val layout = R.layout.main_navigation_fragment

	private val initialScreen: Int
		get() = requireArguments().getInt(INITIAL_SCREEN_KEY)

	override fun setupViewComponents() {
		requireAppCompatActivity().setupToolbar()
		navigation_view.setOnNavigationItemSelectedListener(this)
		navigation_view.selectedItemId = initialScreen
	}

	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.navigation_alphabet -> Unit
			R.id.navigation_colored -> Unit
			R.id.navigation_external -> Unit
			else                     -> return false
		}

		return true
	}

	private fun requireAppCompatActivity() =
		requireActivity() as AppCompatActivity

	private fun AppCompatActivity.setupToolbar() {
		setSupportActionBar(toolbar)
		toolbar.setNavigationOnClickListener { onBackPressed() }
		supportFragmentManager.addOnBackStackChangedListener {
			supportActionBar?.setHomeEnabled()
		}
		supportActionBar?.setHomeEnabled()
	}

	private fun ActionBar.setHomeEnabled() {
		this.setDisplayHomeAsUpEnabled(parentFragmentManager.backStackEntryCount != 0)
	}
}