package ru.endroad.samples.login.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.endroad.samples.login.di.moduleFeatureLogin
import ru.endroad.samples.login.router.di.moduleNavigation
import ru.endroad.samples.login.shared.otp.moduleShareOtp
import ru.endroad.samples.login.shared.session.moduleShareSession

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)
			modules(
				moduleFeatureLogin,
				moduleShareOtp,
				moduleShareSession,
				moduleNavigation
			)
		}
	}
}