package ru.endroad.samples.screen.game.view

import org.koin.androidx.viewmodel.dsl.setIsViewModel
import org.koin.core.definition.BeanDefinition
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.experimental.builder.create

val moduleViewModels = module {
	viewModel<MenuViewModel>()
	viewModel<GameViewModel>()
}

inline fun <reified T : Any> Module.viewModel(): BeanDefinition<T> {
	return factory(null, false) { create<T>() }.apply { setIsViewModel() }
}