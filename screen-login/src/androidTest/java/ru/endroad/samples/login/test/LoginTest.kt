package ru.endroad.samples.login.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.endroad.samples.login.framework.DefaultActivityTestRule
import ru.endroad.samples.login.framework.preset.Preset
import ru.endroad.samples.login.mock.PresetData
import ru.endroad.samples.login.screen.LoginScreen
import ru.endroad.samples.login.screen.StubScreen

@RunWith(AndroidJUnit4::class)
class LoginTest {

	@get:Rule
	val activityRule = DefaultActivityTestRule()

	@Test
	fun checkLoginTest() {
		activityRule.launchActivity(null)

		LoginScreen {
			inputPhone.edit.replaceText("+79998887777")
			signPhone {
				hasText("Отправить код")
				click()
			}
			inputCode.edit.replaceText("123456")
			signPhone {
				hasText("Войти")
				click()
			}
		}
		StubScreen {
			isDisplayed()
		}
	}

	@Test
	fun validationTest() {
		activityRule.launchActivity(null)

		LoginScreen {
			inputPhone.edit.replaceText("+799988877771")
			signPhone.isDisabled()
			inputPhone.edit.replaceText("+7999888777")
			signPhone.isDisabled()

			inputPhone.edit.replaceText("+79998887777")
			signPhone.click()

			inputCode.edit.replaceText("12345")
			signPhone.isDisabled()
			inputCode.edit.replaceText("123456")
			signPhone.isEnabled()
		}
	}

	@Test
	fun errorTest() {
		activityRule.launchActivity(null)

		LoginScreen {
			inputPhone.edit.replaceText("+79998887777")
			signPhone {
				hasText("Отправить код")
				click()
			}
			inputCode.edit.replaceText("987654")
			signPhone {
				hasText("Войти")
				click()
			}

			dialog {
				isDisplayed()
			}
		}
	}

	@Test
	fun logoutTest() {
		Preset {
			preference {
				setSession(PresetData.Session.default)
			}
		}
		activityRule.launchActivity(null)

		StubScreen {
			logoutButton.click()
		}
		LoginScreen {
			isDisplayed()
		}
	}

	@Test
	fun socialSignSuccessTest() {
		activityRule.launchActivity(null)

		LoginScreen {
			signFb.click()
			dialog {
				title.hasText("Facebook")
				message.hasText("Имитация экрана входа с помощью социальной сети")
				positiveButton.click()
			}
		}
		StubScreen {
			logoutButton.click()
		}

		LoginScreen {
			signVk.click()
			dialog {
				title.hasText("Vkontakte")
				message.hasText("Имитация экрана входа с помощью социальной сети")
				positiveButton.click()
			}
		}
		StubScreen {
			logoutButton.click()
		}

		LoginScreen {
			signGoogle.click()
			dialog {
				title.hasText("Google")
				message.hasText("Имитация экрана входа с помощью социальной сети")
				positiveButton.click()
			}
		}
		StubScreen {
			logoutButton.click()
		}
	}

	@Test
	fun socialSignErrorTest() {
		activityRule.launchActivity(null)

		LoginScreen {
			signFb.click()
			dialog.negativeButton.click()
			dialog {
				message.hasText("Ошибка авторизации")
				positiveButton.click()
			}
		}

		LoginScreen {
			signVk.click()
			dialog.negativeButton.click()
			dialog {
				message.hasText("Ошибка авторизации")
				positiveButton.click()
			}
		}

		LoginScreen {
			signGoogle.click()
			dialog.negativeButton.click()
			dialog {
				message.hasText("Ошибка авторизации")
				positiveButton.click()
			}
		}
	}
}