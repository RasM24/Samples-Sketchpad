package sample.endroad.coroutines.reality

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import sample.endroad.coroutines.R

class RealityActivity : AppCompatActivity() {

	private val viewModel: RealityViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.reality_activity)
	}
}