package ru.endroad.sample.screen.navigation.feature.navigation

import androidx.fragment.app.Fragment
import ru.endroad.sample.screen.navigation.router.destination.FragmentDestination

class MainNavigationDestination(private val initialScreen: Int) : FragmentDestination {

	override fun createFragment(): Fragment =
		MainNavigationFragment.create(initialScreen)
}