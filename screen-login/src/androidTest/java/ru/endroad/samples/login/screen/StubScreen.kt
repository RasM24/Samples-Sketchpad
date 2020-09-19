package ru.endroad.samples.login.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import ru.endroad.samples.login.R

object StubScreen : Screen<StubScreen>() {
	fun isDisplayed() {
		logoutButton.isDisplayed()
	}

	val logoutButton = KButton { withId(R.id.logout_button) }
}