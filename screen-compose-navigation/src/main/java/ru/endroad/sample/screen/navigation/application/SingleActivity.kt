package ru.endroad.sample.screen.navigation.application

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.OfflineShare
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.router.navigator.NavigationCommandExecutor
import ru.endroad.sample.screen.navigation.router.navigator.NavigationCommandStack
import ru.endroad.sample.screen.navigation.router.navigator.NavigationScenesStack

@InternalCoroutinesApi
class SingleActivity : AppCompatActivity() {

	private val navigator: NavigationCommandStack by inject()
	private val commandExecutor: NavigationCommandExecutor by inject()

	private val router: MainNavigationRouter by inject()

	private val navigationScenesStack: NavigationScenesStack by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		commandExecutor.stack = navigationScenesStack
		setContent {
			MaterialTheme {
				val backStackCount = 0 //TODO использовать remember
				val title = "Title" //TODO использовать remember

				Scaffold(
					topBar = { AppBar(title = title, backStackCount = backStackCount, onNavigationClick = { }) },
					bottomBar = { BottomBar(onSelectedTab = ::onNavigationItemSelected) },
				) {
					Crossfade(navigationScenesStack.currentScreen) { screen ->
						screen.collectAsState().value.RenderScreen()
					}
				}
			}
		}
		lifecycleScope.launchWhenResumed {
			navigator.commandFlow.collect { requireActivity ->
				requireActivity(this@SingleActivity)
			}
		}
	}

	@Composable
	private fun AppBar(title: String, backStackCount: Int, onNavigationClick: () -> Unit) = TopAppBar(
		title = { Text(text = title) },
		navigationIcon = {
			if (backStackCount != 0) {
				IconButton(onClick = onNavigationClick) {
					Icon(
						imageVector = Icons.Filled.ArrowBack,
						contentDescription = "Navigation"
					)
				}
			}
		}
	)

	@Composable
	private fun BottomBar(onSelectedTab: (NavigationTab) -> Unit) = BottomNavigation {
		BottomBarItem(onClick = { onSelectedTab(NavigationTab.ALPHABET) }, icon = Icons.Outlined.Home, descriptionRes = R.string.title_alphabet)
		BottomBarItem(onClick = { onSelectedTab(NavigationTab.COLORED) }, icon = Icons.Outlined.Apps, descriptionRes = R.string.title_colored)
		BottomBarItem(onClick = { onSelectedTab(NavigationTab.EXTERNAL) }, icon = Icons.Outlined.OfflineShare, descriptionRes = R.string.title_external)
	}

	@Composable
	private fun BottomBarItem(onClick: () -> Unit, icon: ImageVector, @StringRes descriptionRes: Int) {
		IconButton(onClick = onClick) {
			Icon(
				imageVector = icon,
				contentDescription = stringResource(descriptionRes)
			)
		}
	}


	//	override fun setupViewComponents() {
//		requireAppCompatActivity().setupToolbar()
//		navigation_view.setOnNavigationItemSelectedListener(this)
//		navigation_view.selectedItemId = initialScreen
//	}
//
	private fun onNavigationItemSelected(tab: NavigationTab) {
		when (tab) {
			NavigationTab.ALPHABET -> router.openAlphabetScreen()
			NavigationTab.COLORED -> router.openColoredScreen()
			NavigationTab.EXTERNAL -> router.openExternalLinksScreen()
		}
	}
//
//	private fun requireAppCompatActivity() =
//		requireActivity() as AppCompatActivity
//
//	private fun AppCompatActivity.setupToolbar() {
//		setSupportActionBar(toolbar)
//		toolbar.setNavigationOnClickListener { onBackPressed() }
//		supportFragmentManager.addOnBackStackChangedListener {
//			supportActionBar?.setHomeEnabled()
//		}
//		supportActionBar?.setHomeEnabled()
//	}
//
//	private fun ActionBar.setHomeEnabled() {
//		this.setDisplayHomeAsUpEnabled(requireFragmentManager().backStackEntryCount != 0)
//	}

	override fun onBackPressed() {
		if (!navigationScenesStack.back()) {
			super.onBackPressed()
		}
	}
}