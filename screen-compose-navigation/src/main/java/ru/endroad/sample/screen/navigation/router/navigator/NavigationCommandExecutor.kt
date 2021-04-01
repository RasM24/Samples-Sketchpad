package ru.endroad.sample.screen.navigation.router.navigator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.router.command.Command
import ru.endroad.sample.screen.navigation.router.destination.*

class NavigationCommandExecutor {

	private val manager by inject(NavigationManager::class.java)

	fun execute(command: Command, activity: AppCompatActivity) {
		when (command) {
			is Command.Open -> open(command.destination, activity.baseContext, activity.supportFragmentManager)
			is Command.Replace -> replace(command.destination)
			is Command.ChangeRoot -> changeRoot(command.destination)
		}
	}

	private fun open(destination: Destination, context: Context, fragmentManager: FragmentManager) {
		when (destination) {
			is DialogFragmentDestination -> destination.createFragment().show(fragmentManager, "DIALOG_KEY")
			is SystemDestination         -> context.startActivity(destination.createIntent())
			is SceneDestination          -> manager.openScreen(destination.createScene())
		}
	}

	private fun replace(destination: Destination) {
		when (destination) {
			is SceneDestination -> manager.replaceScreen(destination.createScene())
		}
	}

	private fun changeRoot(destination: Destination) {
		when (destination) {
			is SceneDestination -> manager.changeStack(destination.createScene())
		}
	}
}