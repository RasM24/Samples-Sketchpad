package ru.endroad.sample.screen.navigation.feature.external.destination

import android.content.Intent
import android.net.Uri
import ru.endroad.sample.screen.navigation.router.destination.SystemDestination

class PhoneDestination(private val phone: String) : SystemDestination {

	override fun createIntent(): Intent =
		Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
			.apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
}