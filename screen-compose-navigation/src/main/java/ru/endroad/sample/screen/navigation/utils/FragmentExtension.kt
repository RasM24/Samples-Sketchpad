package ru.endroad.sample.screen.navigation.utils

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

inline fun <reified F : Fragment> F.withArguments(vararg pairs: Pair<String, Any?>): F {
	arguments = bundleOf(*pairs)
	return this
}