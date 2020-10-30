package ru.endroad.samples.screen.game.router.routers

import ru.endroad.samples.screen.game.router.navigator.Navigator
import ru.endroad.samples.screen.game.view.GameFragment
import ru.endroad.samples.screen.game.view.MenuFragment

class MainRouter(private val navigatorHolder: Navigator) {

	fun openMenu() {
		navigatorHolder.changeRoot(MenuFragment())
	}

	fun startGame() {
		navigatorHolder.open(GameFragment())
	}
}