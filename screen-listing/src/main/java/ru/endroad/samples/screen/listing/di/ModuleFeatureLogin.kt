package ru.endroad.samples.screen.listing.di

import org.koin.androidx.viewmodel.dsl.setIsViewModel
import org.koin.core.definition.BeanDefinition
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.experimental.builder.create
import ru.endroad.samples.screen.listing.view.ListingViewModel

val moduleFeatureLogin = module {
	viewModel<ListingViewModel>()
}

inline fun <reified T : Any> Module.viewModel(): BeanDefinition<T> {
	return factory(null, false) { create<T>() }.apply { setIsViewModel() }
}