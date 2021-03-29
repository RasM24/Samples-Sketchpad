package ru.endroad.samples.login.application

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
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

	private val navigator: Navigator by inject()
	private val mainRouter: MainRouter by inject()

	private val navigationViewModel: NavigationViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		navigator.hubActivity = this
		navigator.navigationViewModel = this.navigationViewModel
		super.onCreate(savedInstanceState)

		setContent {
			MaterialTheme {
				Scaffold {
					Crossfade(navigationViewModel.currentScreen) { screen ->
						screen.collectAsState().value.RenderScreen()
					}
				}
			}
		}
	}

	override fun onDestroy() {
		navigator.hubActivity = null
		super.onDestroy()
	}

	override fun onFirstCreate() {
		mainRouter.openFirstScreen()
	}
}