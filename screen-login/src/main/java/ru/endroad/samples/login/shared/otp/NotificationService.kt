package ru.endroad.samples.login.shared.otp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import ru.endroad.samples.login.R

interface NotificationService {
	fun sendPush(message: String)
}

class OtpNotificationService(
	private val context: Context
) : NotificationService {

	private companion object {
		const val CHANNEL_ID = "OTP_CHANNEL"
		const val CHANNEL_NAME = "OTP_CHANNEL"
		const val NOTIFY_ID = 777
		const val OTP_PUSH_TITLE = "Ваш код верификации"
	}

	override fun sendPush(message: String) {
		val notificationBuilder = NotificationCompat.Builder(context, "channelId").apply {
			setSmallIcon(R.mipmap.ic_endroad_logo)
			setContentTitle(OTP_PUSH_TITLE)
			setContentText(message)
			setAutoCancel(true)
			setNumber(1)
			setChannelId(CHANNEL_ID)
			setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
			setVibrate(longArrayOf(200, 100, 200))
		}

		getNotificationManager(context).notify(NOTIFY_ID, notificationBuilder.build())
	}

	private fun getNotificationManager(context: Context): NotificationManager {
		val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
				.let(notificationManager::createNotificationChannel)
		}

		return notificationManager
	}
}