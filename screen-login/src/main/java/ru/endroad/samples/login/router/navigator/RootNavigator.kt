package ru.endroad.samples.login.router.navigator

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

class RootNavigator(@IdRes override val container: Int) : Navigator {
	override var fragmentManager: FragmentManager? = null
}