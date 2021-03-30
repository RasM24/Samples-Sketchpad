package ru.endroad.sample.screen.navigation.feature.colored.cyan

import ru.endroad.sample.screen.navigation.utils.Scene
import ru.endroad.sample.screen.navigation.router.destination.SceneDestination

object CyanDestination : SceneDestination {

	override fun createScene(): Scene =
		CyanScene()
}