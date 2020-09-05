package ru.endroad.samples.login.application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.endroad.samples.login.R

class SingleActivity : AppCompatActivity() {

	private val applicationThemeId = R.style.AppTheme

	override fun onCreate(savedInstanceState: Bundle?) {
		setTheme(applicationThemeId)
		super.onCreate(savedInstanceState)
		setContentView(R.layout.hub_activity)

	}
}