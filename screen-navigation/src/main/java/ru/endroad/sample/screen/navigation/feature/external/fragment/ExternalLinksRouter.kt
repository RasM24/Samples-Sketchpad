package ru.endroad.sample.screen.navigation.feature.external.fragment

interface ExternalLinksRouter {

	fun shareText(title: String, description: String)
	fun openPhoneNumber(phone: String)
	fun openNetworkSetting()
	fun openApplicationSetting()
	fun openApplicationInMarket(packageName: String)
	fun openDialogFragment(title: String, message: String)
}