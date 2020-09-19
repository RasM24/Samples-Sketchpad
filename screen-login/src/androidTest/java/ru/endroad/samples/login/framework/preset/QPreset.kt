package ru.endroad.samples.login.framework.preset

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.samples.login.shared.session.Session
import ru.endroad.samples.login.shared.session.SessionDataSource

object QPreset : Preset, PreferencePreset {

	val sessionDataSource: SessionDataSource by inject(SessionDataSource::class.java)

	override fun preference(body: PreferencePreset.() -> Unit) {
		body(this)
	}

	override fun setSession(session: Session?) {
		sessionDataSource.set(session)
	}

	override fun clear() {
		sessionDataSource.set(null)
	}
}