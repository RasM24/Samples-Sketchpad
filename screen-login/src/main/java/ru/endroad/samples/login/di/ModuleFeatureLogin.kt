package ru.endroad.samples.login.di

import androidx.preference.PreferenceManager
import org.koin.androidx.viewmodel.dsl.setIsViewModel
import org.koin.core.definition.BeanDefinition
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.experimental.builder.create
import org.koin.experimental.builder.single
import ru.endroad.samples.login.domain.*
import ru.endroad.samples.login.shared.social.SignWithFacebookUseCase
import ru.endroad.samples.login.shared.social.SignWithGoogleUseCase
import ru.endroad.samples.login.shared.social.SignWithVkontakteUseCase
import ru.endroad.samples.login.view.LoginViewModel

val moduleFeatureLogin = module {
	single { PreferenceManager.getDefaultSharedPreferences(get()) }

	single<SignWithFacebookUseCase>()
	single<SignWithGoogleUseCase>()
	single<SignWithVkontakteUseCase>()
	single<PhoneValidator>()

	viewModel<LoginViewModel>()
}

inline fun <reified T : Any> Module.viewModel(): BeanDefinition<T> {
	return factory(null, false) { create<T>() }.apply { setIsViewModel() }
}