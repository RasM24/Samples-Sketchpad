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
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.router.navigator.NavigationCommandStack
import ru.endroad.sample.screen.navigation.router.navigator.NavigationManager

@InternalCoroutinesApi
class SingleActivity : AppCompatActivity() {

	private val navigator: NavigationCommandStack by inject()

	private val router: MainNavigationRouter by inject()

	private val manager: NavigationManager by inject()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MaterialTheme {
				val backStackCount = 0 //TODO использовать remember
				val title = "Title" //TODO использовать remember

				Scaffold(
					topBar = { AppBar(title = title, backStackCount = backStackCount, onNavigationClick = { }) },
					bottomBar = { BottomBar(onSelectedTab = ::onNavigationItemSelected) },
				) {
					Crossfade(manager.currentScreen) { screen ->
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

	private fun onNavigationItemSelected(tab: NavigationTab) {
		when (tab) {
			NavigationTab.ALPHABET -> router.openAlphabetScreen()
			NavigationTab.COLORED -> router.openColoredScreen()
			NavigationTab.EXTERNAL -> router.openExternalLinksScreen()
		}
	}

	override fun onBackPressed() {
		if (!manager.back()) {
			super.onBackPressed()
		}
	}
}