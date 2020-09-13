package ru.endroad.samples.login.view

import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.fragment_auth.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.libraries.camp.extension.hideViews
import ru.endroad.libraries.camp.extension.showViews
import ru.endroad.libraries.camp.fragment.CampFragment
import ru.endroad.libraries.mvi.core.view.MviView

class LoginFragment : CampFragment(), MviView<LoginScreenState, LoginScreenEvent> {

	override val layout: Int = ru.endroad.samples.login.R.layout.fragment_auth

	override val presenter by viewModel<LoginViewModel>()

	override fun setupViewComponents() {
		bindRenderState(this)

		sign_fb.setOnClickListener { presenter.reduce(LoginScreenEvent.ClickFacebookSign) }
		sign_google.setOnClickListener { presenter.reduce(LoginScreenEvent.ClickGoogleSign) }
		sign_vk.setOnClickListener { presenter.reduce(LoginScreenEvent.ClickVkontakteSign) }

		sign_phone.setOnClickListener { presenter.reduce(LoginScreenEvent.ClickSendOtpCode(input_phone.text.toString())) }
		resend.setOnClickListener { presenter.reduce(LoginScreenEvent.ClickResendCode(input_phone.text.toString())) }

		input_code.doOnTextChanged { text, _, _, _ -> presenter.reduce(LoginScreenEvent.ChangeCode(text.toString())) }
		input_phone.doOnTextChanged { text, _, _, _ -> presenter.reduce(LoginScreenEvent.ChangePhone(text.toString())) }
	}

	override fun render(state: LoginScreenState) {
		when (state) {
			is LoginScreenState.Initialized -> {
				showViews(input_layout_phone, sign_phone, text_agreement)
				hideViews(resend, input_layout_code)
				sign_phone.text = "Отправить код"
				sign_phone.isEnabled = state.isPhoneValidate
				sign_phone.setOnClickListener { presenter.reduce(LoginScreenEvent.ClickSendOtpCode(input_phone.text.toString())) }
			}

			is LoginScreenState.VerifyCode  -> {
				showViews(input_layout_phone, input_layout_code, sign_phone, resend, text_agreement)
				sign_phone.text = "Войти"
				sign_phone.isEnabled = state.isCodeValidate
				sign_phone.setOnClickListener { presenter.reduce(LoginScreenEvent.ClickCheckOtpCode(input_code.text.toString())) }
			}
		}
	}
}