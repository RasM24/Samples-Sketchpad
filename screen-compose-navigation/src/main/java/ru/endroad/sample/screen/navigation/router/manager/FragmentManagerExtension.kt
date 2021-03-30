package ru.endroad.sample.screen.navigation.router.manager

import androidx.annotation.IdRes
import androidx.fragment.app.*

private val Fragment.key: String? get() = this::class.simpleName

fun FragmentManager.changeRoot(fragment: Fragment, animation: FragmentAnimation, @IdRes container: Int) {
	for (i in 0 until backStackEntryCount) popBackStack()

	beginTransaction().run {
		setAnimationTransaction(animation)
		replace(container, fragment)
		commitAllowingStateLoss()
	}
}

fun FragmentManager.replace(fragment: Fragment, animation: FragmentAnimation, @IdRes container: Int) {
	beginTransaction().run {
		setAnimationTransaction(animation)
		replace(container, fragment)
		if (backStackEntryCount != 0) {
			popBackStack()
			addToBackStack(fragment.key)
		}
		commitAllowingStateLoss()
	}
}

fun FragmentManager.forwardTo(fragment: Fragment, animation: FragmentAnimation, @IdRes container: Int) {
	findFragmentById(container)?.onHiddenChanged(true)
	beginTransaction().run {
		setAnimationTransaction(animation)
		replace(container, fragment)
		addToBackStack(fragment.key)
		commitAllowingStateLoss()
	}
}

fun FragmentManager.showNowDialog(fragment: DialogFragment) {
	fragment.show(this, fragment.key)
}

private fun FragmentTransaction.setAnimationTransaction(animation: FragmentAnimation) {
	animation.run { setCustomAnimations(enter, exit) }
}