package ru.endroad.samples.login.application

import android.os.Bundle
import org.koin.android.ext.android.inject
import ru.endroad.component.core.CampActivity
import ru.endroad.samples.login.R
import ru.endroad.samples.login.router.navigator.Navigator
import ru.endroad.samples.login.router.routers.MainRouter

//TODO UI - добавить маску для InputView ввода телефона
//TODO UX - улучшить удобство пользования. Например автоматическое переключение фокуса после ввода номера
//TODO TechTask - убрать мусор и smellCode после реализации sample-модуля
//TODO UI-тесты - отрефакторить тесты, после того как выработаются Bad и Good practices
//TODO Router - отрефакторить роутер и навигатор, после того как выработаются Bad и Good practices
class SingleActivity : CampActivity() {

	override val layout = R.layout.hub_activity
	override val theme = R.style.AppTheme

	val navigator: Navigator by inject()
	val mainRouter: MainRouter by inject()

	override fun onCreate(savedInstanceState: Bundle?) {
		navigator.hubActivity = this
		super.onCreate(savedInstanceState)
	}

	override fun onDestroy() {
		navigator.hubActivity = null
		super.onDestroy()
	}

	override fun onFirstCreate() {
		mainRouter.openFirstScreen()
	}
}