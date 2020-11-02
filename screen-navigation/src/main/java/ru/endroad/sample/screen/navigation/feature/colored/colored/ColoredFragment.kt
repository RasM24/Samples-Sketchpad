package ru.endroad.sample.screen.navigation.feature.colored.colored

import ru.endroad.libraries.camp.fragment.CampFragment
import ru.endroad.sample.screen.navigation.R

class ColoredFragment : CampFragment() {

	override val layout = R.layout.colored_fragment

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.title_colored))
	}
}