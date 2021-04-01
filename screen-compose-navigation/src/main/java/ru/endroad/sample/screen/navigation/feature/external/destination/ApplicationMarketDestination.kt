package ru.endroad.sample.screen.navigation.feature.external.destination

import android.content.Intent
import android.net.Uri
import ru.endroad.sample.screen.navigation.router.destination.SystemDestination

class ApplicationMarketDestination(private val packageName: String) : SystemDestination {

	private val marketLink = "market://details?id="

	override fun createIntent(): Intent =
		Intent(Intent.ACTION_VIEW, Uri.parse("$marketLink$packageName"))
			.apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
}