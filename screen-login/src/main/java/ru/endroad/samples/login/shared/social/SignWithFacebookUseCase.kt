package ru.endroad.samples.login.shared.social

import ru.endroad.samples.login.router.routers.MockSocialSignRouter

class SignWithFacebookUseCase(private val socialSignRouter: MockSocialSignRouter) {

	suspend operator fun invoke(): SocialCredential = socialSignRouter.openFbSignDialog()
}