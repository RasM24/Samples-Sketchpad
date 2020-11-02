package ru.endroad.sample.screen.navigation.feature.colored.magenta

import androidx.fragment.app.Fragment
import ru.endroad.sample.screen.navigation.router.destination.FragmentDestination

object MagentaDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		MagentaFragment()
}