package ru.endroad.sample.screen.navigation.application

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import ru.endroad.component.core.CampActivity
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.router.navigator.NavigationCommandStack

@InternalCoroutinesApi
class SingleActivity : CampActivity() {

	override val layout = R.layout.root_activity
	override val theme = R.style.ThemeSketchpad

	private val navigator: NavigationCommandStack by inject()

	private val router: HubRouter by inject()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		lifecycleScope.launchWhenResumed {
			navigator.commandFlow.collect { requireActivity ->
				requireActivity(this@SingleActivity)
			}
		}
	}

	override fun onFirstCreate() {
		router.openMainScreen()
	}
}