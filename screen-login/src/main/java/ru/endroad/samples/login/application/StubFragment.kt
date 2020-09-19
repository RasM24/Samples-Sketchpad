package ru.endroad.samples.login.application

import kotlinx.android.synthetic.main.stub_fragment.*
import org.koin.android.ext.android.inject
import ru.endroad.libraries.camp.fragment.CampFragment
import ru.endroad.samples.login.R
import ru.endroad.samples.login.router.routers.LoginRouter
import ru.endroad.samples.login.shared.session.LogoutUseCase

//TODO заполнить экран данными для имитации входа в приложение
class StubFragment : CampFragment() {

	override val layout = R.layout.stub_fragment

	private val loginRouter: LoginRouter by inject()
	private val logoutUseCase by inject<LogoutUseCase>()

	override fun setupViewComponents() {
		logout_button.setOnClickListener { logout() }
	}

	private fun logout() {
		logoutUseCase()
		loginRouter.openLoginScreen()
	}
}