package ru.endroad.sample.screen.navigation.feature.alphabet

import androidx.fragment.app.Fragment
import ru.endroad.sample.screen.navigation.router.destination.FragmentDestination

object AlphabetDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		AlphabetFragment()
}