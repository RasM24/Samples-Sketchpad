package sample.endroad.coroutines.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import sample.endroad.coroutines.reality.data.dataModule

class App : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidContext(this@App)
			modules(viewModelModule, dataModule)
		}
	}
}