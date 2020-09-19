package ru.endroad.samples.login.screen

import com.agoda.kakao.dialog.KAlertDialog
import com.agoda.kakao.edit.KTextInputLayout
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import ru.endroad.samples.login.R

object LoginScreen : Screen<LoginScreen>() {
	val inputPhone = KTextInputLayout { withId(R.id.input_layout_phone) }
	val inputCode = KTextInputLayout { withId(R.id.input_layout_code) }
	val signFb = KButton { withId(R.id.sign_fb) }
	val signVk = KButton { withId(R.id.sign_vk) }
	val signGoogle = KButton { withId(R.id.sign_google) }
	val signPhone = KButton { withId(R.id.sign_phone) }
	val textAgreement = KTextView { withId(R.id.text_agreement) }
	val resend = KButton { withId(R.id.resend) }
	val dialog = KAlertDialog()

	fun isDisplayed() {
		inputPhone.isDisplayed()
		signPhone.isDisplayed()
	}
}