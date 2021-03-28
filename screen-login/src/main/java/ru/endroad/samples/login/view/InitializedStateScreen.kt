package ru.endroad.samples.login.view

import androidx.compose.foundation.layout.*
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
private fun InitStateWithValidatePhonePreview() {
	InitializedStateScreen(
		state = LoginScreenState.Initialized("+79293375503"),
		onChangeText = { /*TODO*/ },
		onSendOtpCode = { /*TODO*/ },
		onFbSignClick = { /*TODO*/ },
		onVkSignClick = { /*TODO*/ },
		onGoogleSignClick = { /*TODO*/ },
	)
}

@Preview
@Composable
private fun InitStateWithInValidatePhonePreview() {
	InitializedStateScreen(
		state = LoginScreenState.Initialized("+7929337550"),
		onChangeText = { /*TODO*/ },
		onSendOtpCode = { /*TODO*/ },
		onFbSignClick = { /*TODO*/ },
		onVkSignClick = { /*TODO*/ },
		onGoogleSignClick = { /*TODO*/ },
	)
}

@Composable
fun InitializedStateScreen(
	state: LoginScreenState.Initialized,
	onChangeText: (String) -> Unit,
	onSendOtpCode: () -> Unit,
	onFbSignClick: () -> Unit,
	onVkSignClick: () -> Unit,
	onGoogleSignClick: () -> Unit,
) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 16.dp),
	) {
		val centerModifier = Modifier
			.align(Alignment.CenterHorizontally)
			.fillMaxWidth(0.7f)

		PhoneInputField(modifier = centerModifier, phone = state.phone, changePhone = onChangeText)
		Spacer(modifier = Modifier.height(16.dp))
		LegalText(modifier = centerModifier)
		Spacer(modifier = Modifier.height(24.dp))
		SendCodeButton(modifier = centerModifier, sendOtpCodeAction = onSendOtpCode, enabled = validate(state.phone))
		Divider()
		SocialNetworkSign(onFbSignClick, onVkSignClick, onGoogleSignClick)
	}
}