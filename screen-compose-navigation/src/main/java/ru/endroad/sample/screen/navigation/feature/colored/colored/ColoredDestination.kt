package ru.endroad.sample.screen.navigation.feature.colored.colored

import androidx.fragment.app.Fragment
import ru.endroad.sample.screen.navigation.router.destination.FragmentDestination

object ColoredDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		ColoredFragment()
}