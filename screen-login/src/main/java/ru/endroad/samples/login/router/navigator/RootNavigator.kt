package ru.endroad.samples.login.router.navigator

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity

class RootNavigator(@IdRes override val container: Int) : Navigator {

	override var hubActivity: AppCompatActivity? = null
}