package ru.endroad.sample.screen.navigation.feature.external

import ru.endroad.libraries.camp.fragment.CampFragment
import ru.endroad.sample.screen.navigation.R

class ExternalLinksFragment : CampFragment() {

	override val layout = R.layout.external_links_fragment

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.title_external))
	}
}