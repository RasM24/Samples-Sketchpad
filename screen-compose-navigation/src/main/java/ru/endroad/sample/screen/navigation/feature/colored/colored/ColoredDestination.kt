package ru.endroad.sample.screen.navigation.feature.colored.colored

import ru.endroad.sample.screen.navigation.utils.Scene
import ru.endroad.sample.screen.navigation.router.destination.SceneDestination

object ColoredDestination : SceneDestination {

	override fun createScene(): Scene =
		ColoredScene()
}