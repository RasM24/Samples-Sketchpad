package ru.endroad.sample.screen.navigation.feature.navigation

import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.main_navigation_fragment.*
import org.koin.android.ext.android.inject
import ru.endroad.component.core.CampFragment
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.utils.withArguments

class MainNavigationFragment : CampFragment(), BottomNavigationView.OnNavigationItemSelectedListener {

	companion object {

		private const val INITIAL_SCREEN_KEY = "INITIAL_SCREEN"

		fun create(initialScreen: Int): Fragment =
			MainNavigationFragment().withArguments(
				INITIAL_SCREEN_KEY to initialScreen
			)
	}

	override val layout = R.layout.main_navigation_fragment

	private val router: MainNavigationRouter by inject()

	private val initialScreen: Int
		get() = requireArguments().getInt(INITIAL_SCREEN_KEY)

	override fun setupViewComponents() {
		requireAppCompatActivity().setupToolbar()
		navigation_view.setOnNavigationItemSelectedListener(this)
		navigation_view.selectedItemId = initialScreen
	}

	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.navigation_alphabet -> router.openAlphabetScreen()
			R.id.navigation_colored -> router.openColoredScreen()
			R.id.navigation_external -> router.openExternalLinksScreen()
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
		this.setDisplayHomeAsUpEnabled(requireFragmentManager().backStackEntryCount != 0)
	}
}