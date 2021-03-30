package ru.endroad.sample.screen.navigation.feature.external.destination

import android.content.Intent
import ru.endroad.sample.screen.navigation.router.destination.SystemDestination

class ActionSendDestination(
	private val title: String,
	private val description: String
) : SystemDestination {

	override fun createIntent(): Intent =
		Intent.createChooser(actionSendIntent, title)
			.apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }

	private val actionSendIntent: Intent
		get() = Intent(Intent.ACTION_SEND).apply {
			type = "text/plain"
			putExtra(Intent.EXTRA_TEXT, description)
		}
}