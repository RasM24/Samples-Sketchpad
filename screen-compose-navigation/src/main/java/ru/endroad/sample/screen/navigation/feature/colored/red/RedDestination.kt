package ru.endroad.sample.screen.navigation.feature.colored.red

import ru.endroad.sample.screen.navigation.utils.Scene
import ru.endroad.sample.screen.navigation.router.destination.SceneDestination

object RedDestination : SceneDestination {

	override fun createScene(): Scene =
		RedScene()
}