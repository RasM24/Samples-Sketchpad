package ru.endroad.samples.screen.game.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.endroad.samples.screen.game.router.di.moduleNavigation
import ru.endroad.samples.screen.game.shared.configuration.moduleConfigurationWorld
import ru.endroad.samples.screen.game.view.moduleViewModels

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)
			modules(
				moduleViewModels,
				moduleNavigation,
				moduleConfigurationWorld,
			)
		}
	}
}