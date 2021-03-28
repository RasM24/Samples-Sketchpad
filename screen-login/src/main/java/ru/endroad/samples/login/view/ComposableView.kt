package ru.endroad.samples.login.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.endroad.samples.login.R

@Composable
internal fun RenderStubView() {
	Box(modifier = Modifier.fillMaxSize()) {
		Text(modifier = Modifier.align(Alignment.Center), text = "Здесь будет что-то") //TODO HardcodeText
	}
}

@Composable
internal fun PhoneInputField(modifier: Modifier, phone: String, changePhone: (String) -> Unit) =
	Column(modifier = modifier) {
		OutlinedTextField(
			modifier = Modifier.fillMaxWidth(),
			value = phone,
			onValueChange = changePhone,
			label = { Text(stringResource(id = R.string.auth_phone_hint)) },
			singleLine = true,
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
		)

		Text(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 8.dp),
			style = MaterialTheme.typography.caption,
			text = "На этот номер придет код" //TODO HardcoreText
		)
	}


@Composable
internal fun CodeInputField(modifier: Modifier, code: String, changeCode: (String) -> Unit, maxLength: Int) =
	Column(modifier = modifier) {
		OutlinedTextField(
			modifier = Modifier.fillMaxWidth(),
			value = code,
			onValueChange = { if (it.length <= maxLength) changeCode(it) },
			label = { Text(stringResource(id = R.string.auth_code_hint)) },
			singleLine = true,
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
		)
		Text(
			modifier = Modifier
				.align(Alignment.End)
				.padding(horizontal = 8.dp),
			style = MaterialTheme.typography.caption,
			text = "${code.length}/$maxLength"
		)
	}

@Composable
internal fun LegalText(modifier: Modifier) =
	Text(modifier = modifier, text = stringResource(id = R.string.login_agreement), style = MaterialTheme.typography.caption)

@Composable
internal fun SendCodeButton(modifier: Modifier, sendOtpCodeAction: () -> Unit, enabled: Boolean) =
	Button(
		modifier = modifier,
		onClick = sendOtpCodeAction,
		enabled = enabled,
	) { Text(text = "Отправить код") } //TODO HardcodeText

@Composable
internal fun ResendCodeButton(modifier: Modifier, resendOtpCodeAction: () -> Unit) =
	OutlinedButton(
		modifier = modifier,
		onClick = resendOtpCodeAction,
	) { Text(text = stringResource(id = R.string.login_resend)) }

@Composable
internal fun CheckCodeButton(modifier: Modifier, checkOtpCodeAction: () -> Unit, enabled: Boolean) =
	Button(
		modifier = modifier,
		onClick = checkOtpCodeAction,
		enabled = enabled,
	) { Text(text = "Войти") } //TODO HardcodeText

@Composable
internal fun Divider() =
	Row(
		horizontalArrangement = Arrangement.Center,
		modifier = Modifier
			.fillMaxWidth()
			.padding(32.dp),
	) {
		GradientView(invertedDirection = false)

		Text(
			modifier = Modifier
				.align(Alignment.CenterVertically)
				.padding(8.dp),
			text = "OR",
			color = colorResource(id = R.color.grey), //TODO Theme unused
		)

		GradientView(invertedDirection = true)
	}

@Composable
private fun RowScope.GradientView(invertedDirection: Boolean) {
	val startColor = colorResource(id = R.color.grey) //TODO Theme unused
	val endColor = colorResource(id = R.color.transparent) //TODO Theme unused

	val colorList = if (invertedDirection) {
		listOf(startColor, startColor, endColor)
	} else {
		listOf(endColor, startColor, startColor)
	}

	Box(
		modifier = Modifier
			.height(1.dp)
			.weight(1f)
			.align(Alignment.CenterVertically)
			.background(brush = Brush.horizontalGradient(colors = colorList))
	)
}

@Composable
internal fun SocialNetworkSign(onFbSignClick: () -> Unit, onVkSignClick: () -> Unit, onGoogleSignClick: () -> Unit) =
	Row(
		horizontalArrangement = Arrangement.Center,
		modifier = Modifier.fillMaxWidth(),
	) {
		IconButton(onClick = onFbSignClick, modifier = Modifier.padding(16.dp)) {
			Icon(painter = painterResource(R.drawable.ic_facebook), contentDescription = "")
		}
		IconButton(onClick = onVkSignClick, modifier = Modifier.padding(16.dp)) {
			Icon(painter = painterResource(R.drawable.ic_vk), contentDescription = "")
		}
		IconButton(onClick = onGoogleSignClick, modifier = Modifier.padding(16.dp)) {
			Icon(painter = painterResource(R.drawable.ic_google_plus), contentDescription = "")
		}
	}