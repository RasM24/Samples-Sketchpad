package ru.endroad.sample.screen.navigation.router.navigator

import android.content.Context
import androidx.fragment.app.FragmentManager
import ru.endroad.sample.screen.navigation.router.command.Command
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

	fun execute(command: Command) {
		when (command) {
			is Command.Open -> open(command.destination)
			is Command.Replace -> replace(command.destination)
			is Command.ChangeRoot -> changeRoot(command.destination)
		}
	}

	private fun open(destination: Destination) {
		when (destination) {
			is FragmentDestination -> fragmentManager.forwardTo(
				destination.createFragment(),
				defaultForwardAnimation,
				container
			)
			is DialogFragmentDestination -> fragmentManager.showNowDialog(destination.createFragment())
			is ActivityDestination -> context.startActivity(destination.createIntent())
			is SystemDestination -> navigatorHolder.hubActivity?.startActivity(destination.createIntent())
		}
	}

	private fun changeRoot(destination: Destination) {
		when (destination) {
			is FragmentDestination -> fragmentManager.changeRoot(
				destination.createFragment(),
				defaultReplaceAnimation,
				container
			)
			is ActivityDestination -> TODO("Not implemented")
		}
	}

	private fun replace(destination: Destination) {
		when (destination) {
			is FragmentDestination -> fragmentManager.replace(
				destination.createFragment(),
				defaultReplaceAnimation,
				container
			)
			is ActivityDestination -> TODO("Not implemented")
		}
	}
}