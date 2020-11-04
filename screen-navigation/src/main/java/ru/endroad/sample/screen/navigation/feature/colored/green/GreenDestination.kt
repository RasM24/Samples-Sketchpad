package ru.endroad.sample.screen.navigation.feature.colored.green

import androidx.fragment.app.Fragment
import ru.endroad.sample.screen.navigation.router.destination.FragmentDestination

object GreenDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		GreenFragment()
}