package ru.endroad.samples.login.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun RenderStubView() {
	Box(modifier = Modifier.fillMaxSize()) {
		Text(modifier = Modifier.align(Alignment.Center), text = "Здесь будет что-то")
	}
}