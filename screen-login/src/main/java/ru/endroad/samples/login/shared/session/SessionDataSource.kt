package ru.endroad.samples.login.shared.session

import android.content.SharedPreferences
import com.google.gson.Gson

interface SessionDataSource {
	fun set(session: Session?)
	fun get(): Session?
}

class SessionLocalDataSource(
	private val preferences: SharedPreferences
) : SessionDataSource {

	companion object {
		private const val PREF_SESSION = "session"
	}

	override fun set(session: Session?) {
		preferences.edit()
			.putString(PREF_SESSION, Gson().toJson(session))
			.apply()
	}

	override fun get(): Session? =
		preferences.getString(PREF_SESSION, null)
			?.let { Gson().fromJson(it, Session::class.java) }

}