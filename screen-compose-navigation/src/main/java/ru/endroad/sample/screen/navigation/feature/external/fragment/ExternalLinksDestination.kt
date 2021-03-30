package ru.endroad.sample.screen.navigation.feature.external.fragment

import ru.endroad.sample.screen.navigation.utils.Scene
import ru.endroad.sample.screen.navigation.router.destination.SceneDestination

object ExternalLinksDestination : SceneDestination {

	override fun createScene(): Scene =
		ExternalLinksScene()
}