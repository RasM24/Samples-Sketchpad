package ru.endroad.samples.screen.listing.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.endroad.samples.screen.listing.di.moduleFeatureListing
import ru.endroad.samples.screen.listing.router.di.moduleNavigation
import ru.endroad.samples.screen.listing.shared.movies.moduleMovies
import ru.endroad.samples.screen.listing.shared.promo.modulePromo
import ru.endroad.samples.screen.listing.shared.series.moduleSeries

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)
			modules(
				moduleFeatureListing,
				moduleNavigation,
				moduleMovies,
				moduleSeries,
				modulePromo
			)
		}
	}
}