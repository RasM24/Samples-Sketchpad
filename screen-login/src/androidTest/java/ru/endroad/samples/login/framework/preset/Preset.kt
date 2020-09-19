package ru.endroad.samples.login.framework.preset

interface Preset {

	companion object {
		operator fun invoke(body: Preset.() -> Unit) {
			body(QPreset)
		}
	}

	fun preference(body: PreferencePreset.() -> Unit)
}