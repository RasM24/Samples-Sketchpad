package ru.endroad.samples.login.router.navigator

import androidx.appcompat.app.AppCompatActivity
import ru.endroad.samples.login.application.NavigationViewModel

class RootNavigator : Navigator {

	override var hubActivity: AppCompatActivity? = null
	override var navigationViewModel: NavigationViewModel? = null
}