package ru.endroad.sample.screen.navigation.feature.colored

import androidx.fragment.app.Fragment

fun Fragment.getBackStackStringFormatted(): String =
	buildString {
		appendLine("backStack:")
		for (i in 0 until parentFragmentManager.backStackEntryCount) {
			appendLine(parentFragmentManager.getBackStackEntryAt(i).name)
		}
	}