package ru.endroad.samples.login.router.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.endroad.navigation.*

interface Navigator {
	val container: Int
	var fragmentManager: FragmentManager?

	fun open(fragment: Fragment) {
		fragmentManager?.forwardTo(fragment, defaultForwardAnimation, container)
	}

	fun replace(fragment: Fragment) {
		fragmentManager?.replace(fragment, defaultReplaceAnimation, container)
	}

	fun changeRoot(fragment: Fragment) {
		fragmentManager?.changeRoot(fragment, defaultReplaceAnimation, container)
	}

	fun back() {
		fragmentManager?.back()
	}
}