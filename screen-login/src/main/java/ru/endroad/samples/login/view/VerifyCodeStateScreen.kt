package ru.endroad.samples.login.view

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val PHONE_LENGTH = 12
private fun validate(phone: String): Boolean =
	phone.length == PHONE_LENGTH

@Preview
@Composable
fun VerifyCodeStatePreview() {
	VerifyCodeStateScreen(
		state = LoginScreenState.VerifyCode("+79293375503", code = "345"),
		changePhone = { /*TODO*/ },
		changeCode = { /*TODO*/ },
		checkOtpCode = { /*TODO*/ },
		resendOtpCode = { /*TODO*/ },
		onFbSignClick = { /*TODO*/ },
		onVkSignClick = { /*TODO*/ },
		onGoogleSignClick = { /*TODO*/ },
	)
}

@Composable
fun VerifyCodeStateScreen(
	state: LoginScreenState.VerifyCode,
	changePhone: (String) -> Unit,
	changeCode: (String) -> Unit,
	checkOtpCode: () -> Unit,
	resendOtpCode: () -> Unit,
	onFbSignClick: () -> Unit,
	onVkSignClick: () -> Unit,
	onGoogleSignClick: () -> Unit,
) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.verticalScroll(state = ScrollState(0), enabled = true)
			.padding(vertical = 16.dp),
	) {
		val centerModifier = Modifier
			.align(Alignment.CenterHorizontally)
			.fillMaxWidth(0.7f)

		PhoneInputField(modifier = centerModifier, phone = state.phone, changePhone = changePhone)
		Spacer(modifier = Modifier.height(16.dp))
		CodeInputField(modifier = centerModifier, code = state.code, changeCode = changeCode, maxLength = 6)
		Spacer(modifier = Modifier.height(24.dp))
		ResendCodeButton(modifier = centerModifier, resendOtpCodeAction = resendOtpCode)
		Spacer(modifier = Modifier.height(16.dp))
		LegalText(modifier = centerModifier)
		Spacer(modifier = Modifier.height(24.dp))
		CheckCodeButton(modifier = centerModifier, checkOtpCodeAction = checkOtpCode, enabled = validate(state.phone))
		Divider()
		SocialNetworkSign(onFbSignClick, onVkSignClick, onGoogleSignClick)
	}
}