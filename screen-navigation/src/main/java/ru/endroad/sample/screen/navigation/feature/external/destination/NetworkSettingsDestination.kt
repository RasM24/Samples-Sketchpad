package ru.endroad.sample.screen.navigation.feature.external.destination

import android.content.Intent
import android.provider.Settings
import ru.endroad.sample.screen.navigation.router.destination.SystemDestination

object NetworkSettingsDestination : SystemDestination {

	override fun createIntent(): Intent =
		Intent(Settings.ACTION_WIRELESS_SETTINGS)
}