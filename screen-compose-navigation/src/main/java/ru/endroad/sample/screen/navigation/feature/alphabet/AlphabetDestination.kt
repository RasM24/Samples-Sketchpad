package ru.endroad.sample.screen.navigation.feature.alphabet

import ru.endroad.sample.screen.navigation.utils.Scene
import ru.endroad.sample.screen.navigation.router.destination.SceneDestination

object AlphabetDestination : SceneDestination {

	override fun createScene(): Scene =
		AlphabetScene()
}