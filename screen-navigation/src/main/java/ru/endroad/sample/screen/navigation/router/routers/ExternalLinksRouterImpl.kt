package ru.endroad.sample.screen.navigation.router.routers

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.feature.external.fragment.ExternalLinksRouter
import ru.endroad.sample.screen.navigation.feature.external.destination.*
import ru.endroad.sample.screen.navigation.feature.external.dialog.DialogDestination
import ru.endroad.sample.screen.navigation.router.di.rootNavigatorQualifier
import ru.endroad.sample.screen.navigation.router.navigator.Navigator

class ExternalLinksRouterImpl : ExternalLinksRouter {

	private val rootNavigator: Navigator by inject(Navigator::class.java, rootNavigatorQualifier)

	override fun shareText(title: String, description: String) {
		rootNavigator.open(ActionSendDestination(title, description))
	}

	override fun openPhoneNumber(phone: String) {
		rootNavigator.open(PhoneDestination(phone))
	}

	override fun openNetworkSetting() {
		rootNavigator.open(NetworkSettingsDestination)
	}

	override fun openApplicationSetting() {
		rootNavigator.open(AppSettingsDestination)
	}

	override fun openApplicationInMarket(packageName: String) {
		rootNavigator.open(ApplicationMarketDestination(packageName))
	}

	override fun openDialogFragment(title: String, message: String) {
		rootNavigator.open(DialogDestination(title, message))
	}
}