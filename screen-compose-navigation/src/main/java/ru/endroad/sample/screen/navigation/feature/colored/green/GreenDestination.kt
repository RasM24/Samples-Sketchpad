package ru.endroad.sample.screen.navigation.feature.colored.green

import ru.endroad.sample.screen.navigation.utils.Scene
import ru.endroad.sample.screen.navigation.router.destination.SceneDestination

object GreenDestination : SceneDestination {

	override fun createScene(): Scene =
		GreenScene()
}