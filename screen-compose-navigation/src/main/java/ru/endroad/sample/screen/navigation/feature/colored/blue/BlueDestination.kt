package ru.endroad.sample.screen.navigation.feature.colored.blue

import ru.endroad.sample.screen.navigation.utils.Scene
import ru.endroad.sample.screen.navigation.router.destination.SceneDestination

object BlueDestination : SceneDestination {

	override fun createScene(): Scene =
		BlueScene()
}