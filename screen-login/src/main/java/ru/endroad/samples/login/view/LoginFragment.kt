package ru.endroad.samples.login.view

import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.fragment_auth.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.component.core.*
import ru.endroad.samples.login.domain.PhoneValidator
import ru.endroad.samples.login.shared.otp.VerificationCodeValidator

class LoginFragment : MviFragment<LoginScreenState, LoginScreenEvent>() {

	override val layout: Int = ru.endroad.samples.login.R.layout.fragment_auth

	override val viewModel by viewModel<LoginViewModel>()

	private val phoneValidator: PhoneValidator by inject()
	private val verificationCodeValidator: VerificationCodeValidator by inject()

	override fun setupViewComponents() {
		sign_fb.setOnClickListener { viewModel.notice(LoginScreenEvent.ClickFacebookSign) }
		sign_google.setOnClickListener { viewModel.notice(LoginScreenEvent.ClickGoogleSign) }
		sign_vk.setOnClickListener { viewModel.notice(LoginScreenEvent.ClickVkontakteSign) }

		sign_phone.setOnClickListener { viewModel.notice(LoginScreenEvent.ClickSendOtpCode) }
		resend.setOnClickListener { viewModel.notice(LoginScreenEvent.ClickResendCode) }

		input_code.doOnTextChanged { text, _, _, _ -> viewModel.notice(LoginScreenEvent.ChangeCode(text.toString())) }
		input_phone.doOnTextChanged { text, _, _, _ -> viewModel.notice(LoginScreenEvent.ChangePhone(text.toString())) }
	}

	override fun render(state: LoginScreenState) {
		when (state) {
			is LoginScreenState.Initialized -> {
				showViews(input_layout_phone, sign_phone, text_agreement)
				hideViews(resend, input_layout_code)
				sign_phone.text = "Отправить код"
				sign_phone.isEnabled = phoneValidator.validate(state.phone)
				sign_phone.setOnClickListener { viewModel.notice(LoginScreenEvent.ClickSendOtpCode) }
			}

			is LoginScreenState.VerifyCode  -> {
				showViews(input_layout_phone, input_layout_code, sign_phone, resend, text_agreement)
				sign_phone.text = "Войти"
				sign_phone.isEnabled = verificationCodeValidator.validate(state.code)
				sign_phone.setOnClickListener { viewModel.notice(LoginScreenEvent.ClickCheckOtpCode) }
			}
		}
	}
}