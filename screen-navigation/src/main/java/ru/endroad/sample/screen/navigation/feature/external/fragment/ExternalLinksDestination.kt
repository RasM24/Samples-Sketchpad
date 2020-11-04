package ru.endroad.sample.screen.navigation.feature.external.fragment

import androidx.fragment.app.Fragment
import ru.endroad.sample.screen.navigation.router.destination.FragmentDestination

object ExternalLinksDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		ExternalLinksFragment()
}