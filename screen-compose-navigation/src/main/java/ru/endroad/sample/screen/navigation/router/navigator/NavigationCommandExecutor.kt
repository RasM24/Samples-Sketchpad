package ru.endroad.sample.screen.navigation.router.navigator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import ru.endroad.sample.screen.navigation.router.command.Command
import ru.endroad.sample.screen.navigation.router.destination.*
import ru.endroad.sample.screen.navigation.router.manager.*

class NavigationCommandExecutor {

	var stack :NavigationScenesStack? = null

	fun execute(command: Command, activity: AppCompatActivity, container: Int) {
		when (command) {
			is Command.Open -> open(command.destination, activity.baseContext, activity.supportFragmentManager, container)
			is Command.Replace -> replace(command.destination, activity.supportFragmentManager, container)
			is Command.ChangeRoot -> changeRoot(command.destination, activity.supportFragmentManager, container)
		}
	}

	private fun open(destination: Destination, context: Context, fragmentManager: FragmentManager, container: Int) {
		when (destination) {
			is FragmentDestination       -> fragmentManager.forwardTo(destination.createFragment(), defaultForwardAnimation, container)
			is DialogFragmentDestination -> fragmentManager.showNowDialog(destination.createFragment())
			is ActivityDestination       -> context.startActivity(destination.createIntent())
			is SystemDestination         -> context.startActivity(destination.createIntent())
			is SceneDestination          -> stack?.openScreen(destination.createScene())
		}
	}

	private fun replace(destination: Destination, fragmentManager: FragmentManager, container: Int) {
		when (destination) {
			is FragmentDestination -> fragmentManager.replace(destination.createFragment(), defaultReplaceAnimation, container)
			is ActivityDestination -> TODO("Not implemented")
			is SceneDestination    -> stack?.replaceScreen(destination.createScene())
		}
	}

	private fun changeRoot(destination: Destination, fragmentManager: FragmentManager, container: Int) {
		when (destination) {
			is SceneDestination    -> stack?.changeStack(destination.createScene())
			is FragmentDestination -> fragmentManager.changeRoot(destination.createFragment(), defaultReplaceAnimation, container)
			is ActivityDestination -> TODO("Not implemented")
		}
	}
}