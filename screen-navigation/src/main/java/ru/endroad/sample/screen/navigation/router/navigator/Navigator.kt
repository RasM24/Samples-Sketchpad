package ru.endroad.sample.screen.navigation.router.navigator

import android.content.Context
import androidx.fragment.app.FragmentManager
import ru.endroad.sample.screen.navigation.router.destination.*
import ru.endroad.sample.screen.navigation.router.manager.*

class Navigator(
	private val container: Int,
	private val navigatorHolder: NavigatorHolder,
) {

	private val fragmentManager: FragmentManager
		get() = requireNotNull(navigatorHolder.hubActivity?.supportFragmentManager)

	private val context: Context
		get() = requireNotNull(navigatorHolder.hubActivity?.baseContext)

	fun open(destination: Destination) {
		when (destination) {
			is FragmentDestination -> fragmentManager.forwardTo(destination.createFragment(), defaultForwardAnimation, container)
			is DialogFragmentDestination -> fragmentManager.showNowDialog(destination.createFragment())
			is ActivityDestination -> context.startActivity(destination.createIntent())
			is SystemDestination -> navigatorHolder.hubActivity?.startActivity(destination.createIntent())
		}
	}

	fun changeRoot(destination: Destination) {
		when (destination) {
			is FragmentDestination -> fragmentManager.changeRoot(destination.createFragment(), defaultReplaceAnimation, container)
			is ActivityDestination -> TODO("Not implemented")
		}
	}

	fun replace(destination: Destination) {
		when (destination) {
			is FragmentDestination -> fragmentManager.replace(destination.createFragment(), defaultReplaceAnimation, container)
			is ActivityDestination -> TODO("Not implemented")
		}
	}
}