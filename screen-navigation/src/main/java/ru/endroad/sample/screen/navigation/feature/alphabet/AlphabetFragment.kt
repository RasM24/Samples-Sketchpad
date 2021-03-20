package ru.endroad.sample.screen.navigation.feature.alphabet

import ru.endroad.component.core.CampFragment
import ru.endroad.sample.screen.navigation.R

class AlphabetFragment : CampFragment() {

	override val layout = R.layout.alphabet_fragment

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.title_alphabet))
	}
}