package ru.endroad.sample.screen.navigation.router.routers

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.feature.external.fragment.ExternalLinksRouter
import ru.endroad.sample.screen.navigation.feature.external.destination.*
import ru.endroad.sample.screen.navigation.feature.external.dialog.DialogDestination
import ru.endroad.sample.screen.navigation.router.command.Command
import ru.endroad.sample.screen.navigation.router.navigator.Navigator

class ExternalLinksRouterImpl : ExternalLinksRouter {

	private val navigator by inject(Navigator::class.java)

	override fun shareText(title: String, description: String) {
		navigator.execute(Command.Open(ActionSendDestination(title, description)))
	}

	override fun openPhoneNumber(phone: String) {
		navigator.execute(Command.Open(PhoneDestination(phone)))
	}

	override fun openNetworkSetting() {
		navigator.execute(Command.Open(NetworkSettingsDestination))
	}

	override fun openApplicationSetting() {
		navigator.execute(Command.Open(AppSettingsDestination))
	}

	override fun openApplicationInMarket(packageName: String) {
		navigator.execute(Command.Open(ApplicationMarketDestination(packageName)))
	}

	override fun openDialogFragment(title: String, message: String) {
		navigator.execute(Command.Open(DialogDestination(title, message)))
	}
}