package sample.endroad.coroutines.application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sample.endroad.coroutines.R

class SingleActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setTheme(R.style.ThemeSketchpad)
		setContentView(R.layout.hub_activity)
	}
}