package ru.endroad.samples.screen.listing.router.routers

import ru.endroad.samples.screen.listing.router.navigator.Navigator
import ru.endroad.samples.screen.listing.view.ListingFragment

class MainRouter(
	private val navigatorHolder: Navigator
) {

	fun openFirstScreen() {
		navigatorHolder.changeRoot(ListingFragment())
	}
}