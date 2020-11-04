package ru.endroad.sample.screen.navigation.feature.external.fragment

import kotlinx.android.synthetic.main.external_links_fragment.*
import org.koin.android.ext.android.inject
import ru.endroad.libraries.camp.fragment.CampFragment
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.feature.external.fragment.ExternalLinksRouter

class ExternalLinksFragment : CampFragment() {

	override val layout = R.layout.external_links_fragment

	private val router: ExternalLinksRouter by inject()

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.title_external))

		action_send_destination_button.setOnClickListener { router.shareText("Поделиться", "HelloWorld!") }
		phone_destination_button.setOnClickListener { router.openPhoneNumber("89291234567") }
		network_setting_destination_button.setOnClickListener { router.openNetworkSetting() }
		app_setting_destination_button.setOnClickListener { router.openApplicationSetting() }
		application_market_destination_button.setOnClickListener { router.openApplicationInMarket("endroad.nitiway") }
	}
}