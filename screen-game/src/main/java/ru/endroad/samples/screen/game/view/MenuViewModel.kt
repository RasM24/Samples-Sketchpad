package ru.endroad.samples.screen.game.view

import androidx.lifecycle.ViewModel
import ru.endroad.samples.screen.game.router.routers.MainRouter

class MenuViewModel(
	private val router: MainRouter,
) : ViewModel() {

	fun startGame() {
		router.startGame()
	}
}