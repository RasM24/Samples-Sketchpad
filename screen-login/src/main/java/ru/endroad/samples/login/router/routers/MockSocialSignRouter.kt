package ru.endroad.samples.login.router.routers

import ru.endroad.samples.login.router.navigator.Navigator
import ru.endroad.samples.login.shared.social.SocialCredential

class MockSocialSignRouter(private val navigatorHolder: Navigator) {

	val vkNetworkName = "Vkontakte"
	val fbNetworkName = "Facebook"
	val googleNetworkName = "Google"

	val mockSocialSignMessage = "Имитация экрана входа с помощью социальной сети"
	val socialCredential = SocialCredential("Go4rMeygtsZb8rvbxnzA")

	suspend fun openVkSignDialog(): SocialCredential =
		navigatorHolder
			.openSignDialog(vkNetworkName, mockSocialSignMessage)
			.let { socialCredential }

	suspend fun openFbSignDialog(): SocialCredential =
		navigatorHolder
			.openSignDialog(fbNetworkName, mockSocialSignMessage)
			.let { socialCredential }

	suspend fun openGoogleSignDialog(): SocialCredential =
		navigatorHolder
			.openSignDialog(googleNetworkName, mockSocialSignMessage)
			.let { socialCredential }
}