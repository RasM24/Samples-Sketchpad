package ru.endroad.sample.screen.navigation.feature.colored.red

import androidx.fragment.app.Fragment
import ru.endroad.sample.screen.navigation.router.destination.FragmentDestination

object RedDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		RedFragment()
}