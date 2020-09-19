package ru.endroad.samples.login.framework

import androidx.test.rule.ActivityTestRule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import ru.endroad.samples.login.application.SingleActivity
import ru.endroad.samples.login.framework.preset.Preset
import ru.endroad.samples.login.shared.otp.OtpCodeGenerator

class DefaultActivityTestRule : ActivityTestRule<SingleActivity>(SingleActivity::class.java, false, false) {

	val otpModule = module {
		single<OtpCodeGenerator>(override = true) { MockCodeGenerator("123456") }
	}

	init {
		loadKoinModules(otpModule)

		Preset {
			preference {
				clear()
			}
		}
	}

}