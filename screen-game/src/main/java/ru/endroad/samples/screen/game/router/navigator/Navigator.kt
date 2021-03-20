package ru.endroad.samples.screen.game.router.navigator

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.endroad.component.core.changeRoot
import ru.endroad.component.core.defaultForwardAnimation
import ru.endroad.component.core.defaultReplaceAnimation
import ru.endroad.component.core.forwardTo

interface Navigator {

	val container: Int
	var hubActivity: AppCompatActivity?

	fun open(fragment: Fragment) {
		hubActivity?.supportFragmentManager?.forwardTo(fragment, defaultForwardAnimation, container)
	}

	fun changeRoot(fragment: Fragment) {
		hubActivity?.supportFragmentManager?.changeRoot(fragment, defaultReplaceAnimation, container)
	}
}