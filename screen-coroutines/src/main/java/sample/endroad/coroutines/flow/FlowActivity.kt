package sample.endroad.coroutines.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import sample.endroad.coroutines.R

class FlowActivity : AppCompatActivity() {

	private val flowViewModel: FlowViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.flow_activity)
	}
}