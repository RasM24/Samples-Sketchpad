package ru.endroad.samples.login.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.endroad.samples.login.di.moduleFeatureLogin

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)
			modules(moduleFeatureLogin)
		}
	}
}