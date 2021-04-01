package ru.endroad.sample.screen.navigation.router.destination

import ru.endroad.sample.screen.navigation.utils.Scene

interface SceneDestination : Destination {

	fun createScene(): Scene
}