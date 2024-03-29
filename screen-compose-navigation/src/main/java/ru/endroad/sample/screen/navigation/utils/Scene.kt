package ru.endroad.sample.screen.navigation.utils

import androidx.compose.runtime.Composable

abstract class Scene {

	@Composable
	abstract fun getTitle(): String

	@Composable
	abstract fun RenderScreen()
}