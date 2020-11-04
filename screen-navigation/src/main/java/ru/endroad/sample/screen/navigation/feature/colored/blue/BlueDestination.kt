package ru.endroad.sample.screen.navigation.feature.colored.blue

import androidx.fragment.app.Fragment
import ru.endroad.sample.screen.navigation.router.destination.FragmentDestination

object BlueDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		BlueFragment()
}