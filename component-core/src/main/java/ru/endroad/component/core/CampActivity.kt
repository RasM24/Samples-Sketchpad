package ru.endroad.component.core

import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity

abstract class CampActivity : AppCompatActivity() {

	@StyleRes
	open val theme: Int? = null

	abstract val layout: Int

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		theme?.let(::setTheme)
		setContentView(layout)

		savedInstanceState ?: onFirstCreate()
	}

	open fun onFirstCreate() = Unit
}