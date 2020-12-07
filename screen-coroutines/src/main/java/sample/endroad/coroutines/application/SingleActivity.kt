package sample.endroad.coroutines.application

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.hub_activity.*
import sample.endroad.coroutines.R
import sample.endroad.coroutines.coroutine.CoroutineActivity
import sample.endroad.coroutines.flow.FlowActivity
import kotlin.reflect.KClass

class SingleActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setTheme(R.style.ThemeSketchpad)
		setContentView(R.layout.hub_activity)

		open_simple_samples.setOnClickListener { startScreen(CoroutineActivity::class) }
		open_flow_samples.setOnClickListener { startScreen(FlowActivity::class) }
	}

	private fun startScreen(kClass: KClass<out Activity>) {
		Intent(this, kClass.java)
			.let(::startActivity)
	}
}