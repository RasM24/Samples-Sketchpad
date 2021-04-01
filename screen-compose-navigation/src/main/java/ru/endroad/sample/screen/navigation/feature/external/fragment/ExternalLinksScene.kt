package ru.endroad.sample.screen.navigation.feature.external.fragment

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.koin.java.KoinJavaComponent.inject
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.utils.Scene

class ExternalLinksScene : Scene() {

	private val router by inject(ExternalLinksRouter::class.java)

	@Composable
	override fun getTitle() = stringResource(id = R.string.title_external)

	@Composable
	override fun RenderScreen() =
		Column(modifier = Modifier.padding(16.dp)) {
			SimpleTextButton(stringId = R.string.action_send_destination) { router.shareText("Поделиться", "HelloWorld!") }
			SimpleTextButton(stringId = R.string.phone_destination_button) { router.openPhoneNumber("89291234567") }
			SimpleTextButton(stringId = R.string.network_setting_destination_button) { router.openNetworkSetting() }
			SimpleTextButton(stringId = R.string.app_setting_destination_button) { router.openApplicationSetting() }
			SimpleTextButton(stringId = R.string.application_market_destination_button) { router.openApplicationInMarket("endroad.nitiway") }
			SimpleTextButton(stringId = R.string.dialog_destination_button) {
				router.openDialogFragment("Hello World!", "Нажмите ок, чтобы закрыть диалог")
			}
		}

	@Composable
	private fun SimpleTextButton(@StringRes stringId: Int, onClick: () -> Unit) =
		Button(
			onClick = onClick,
			modifier = Modifier
				.fillMaxWidth()
				.padding(vertical = 8.dp)
		) {
			Text(text = stringResource(id = stringId))
		}
}