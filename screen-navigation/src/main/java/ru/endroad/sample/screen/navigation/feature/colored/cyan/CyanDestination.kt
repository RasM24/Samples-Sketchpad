package ru.endroad.sample.screen.navigation.feature.colored.cyan

import androidx.fragment.app.Fragment
import ru.endroad.sample.screen.navigation.router.destination.FragmentDestination

object CyanDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		CyanFragment()
}