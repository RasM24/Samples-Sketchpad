package ru.endroad.samples.login.router.navigator

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.endroad.navigation.*

interface Navigator {
	val container: Int
	var hubActivity: AppCompatActivity?

	fun open(fragment: Fragment) {
		hubActivity?.supportFragmentManager?.forwardTo(fragment, defaultForwardAnimation, container)
	}

	fun replace(fragment: Fragment) {
		hubActivity?.supportFragmentManager?.replace(fragment, defaultReplaceAnimation, container)
	}

	fun changeRoot(fragment: Fragment) {
		hubActivity?.supportFragmentManager?.changeRoot(fragment, defaultReplaceAnimation, container)
	}

	fun back() {
		hubActivity?.supportFragmentManager?.back()
	}
}