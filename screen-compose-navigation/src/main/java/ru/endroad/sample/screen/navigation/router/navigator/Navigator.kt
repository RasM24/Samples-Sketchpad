package ru.endroad.sample.screen.navigation.router.navigator

import androidx.appcompat.app.AppCompatActivity
import ru.endroad.sample.screen.navigation.router.command.Command

class Navigator(
	private val fragmentContainer: Int,
	private val commandStack: NavigationCommandStack,
	private val commandExecutor: NavigationCommandExecutor,
) {

	fun execute(command: Command) {
		val executor = { activity: AppCompatActivity ->
			commandExecutor.execute(command, activity, fragmentContainer)
		}
		commandStack.execute(executor)
	}
}