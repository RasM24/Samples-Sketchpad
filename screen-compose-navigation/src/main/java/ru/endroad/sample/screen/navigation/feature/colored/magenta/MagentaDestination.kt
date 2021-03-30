package ru.endroad.sample.screen.navigation.feature.colored.magenta

import ru.endroad.sample.screen.navigation.utils.Scene
import ru.endroad.sample.screen.navigation.router.destination.SceneDestination

object MagentaDestination : SceneDestination {

	override fun createScene(): Scene =
		MagentaScene()
}