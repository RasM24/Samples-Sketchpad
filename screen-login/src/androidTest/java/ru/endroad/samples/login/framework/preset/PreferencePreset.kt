package ru.endroad.samples.login.framework.preset

import ru.endroad.samples.login.shared.session.Session

interface PreferencePreset {

	fun setSession(session: Session?)
	fun clear()
}