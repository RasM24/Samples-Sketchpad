package ru.endroad.sample.screen.navigation.feature.external.dialog

import androidx.fragment.app.DialogFragment
import ru.endroad.sample.screen.navigation.router.destination.DialogFragmentDestination

class DialogDestination(private val title: String, private val message: String) : DialogFragmentDestination {

	override fun createFragment(): DialogFragment =
		SimpleDialogFragment.create(title, message)
}