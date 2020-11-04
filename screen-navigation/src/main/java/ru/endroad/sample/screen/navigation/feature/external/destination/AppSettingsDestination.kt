package ru.endroad.sample.screen.navigation.feature.external.destination

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import ru.endroad.sample.screen.navigation.router.destination.SystemDestination

object AppSettingsDestination : SystemDestination {

	private const val PACKAGE_SCHEME = "package"
	private const val PACKAGE_NAME = "ru.endroad.sample.screen.navigation"

	override fun createIntent(): Intent =
		Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
			addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
			data = Uri.fromParts(PACKAGE_SCHEME, PACKAGE_NAME, null)
		}
}