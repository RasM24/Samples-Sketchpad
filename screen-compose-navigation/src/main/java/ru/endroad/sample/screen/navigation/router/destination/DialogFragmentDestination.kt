package ru.endroad.sample.screen.navigation.router.destination

import androidx.fragment.app.DialogFragment

interface DialogFragmentDestination : Destination {

	fun createFragment(): DialogFragment
}