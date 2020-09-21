package ru.endroad.samples.screen.listing.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.endroad.samples.screen.listing.di.moduleFeatureLogin
import ru.endroad.samples.screen.listing.router.di.moduleNavigation

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)
			modules(
				moduleFeatureLogin,
				moduleNavigation
			)
		}
	}
}