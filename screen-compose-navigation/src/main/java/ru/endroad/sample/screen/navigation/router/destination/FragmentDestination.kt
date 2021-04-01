package ru.endroad.sample.screen.navigation.router.destination

import androidx.fragment.app.Fragment

interface FragmentDestination : Destination {

	fun createFragment(): Fragment
}