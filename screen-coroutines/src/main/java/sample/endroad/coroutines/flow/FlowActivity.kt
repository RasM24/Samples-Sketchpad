package sample.endroad.coroutines.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.coroutine_activity.view.*
import kotlinx.android.synthetic.main.flow_activity.*
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import sample.endroad.coroutines.R
import sample.endroad.coroutines.application.appendText

class FlowActivity : AppCompatActivity() {

	private val flowViewModel: FlowViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.flow_activity)

		setupViewComponent()
		subscribeFlows()
	}

	private fun setupViewComponent() {
		start_flow_shared_button.setOnClickListener { flowViewModel.exampleSharedFlow() }
		start_flow_state_button.setOnClickListener { flowViewModel.exampleStateFlow() }
		button_clear_log.setOnClickListener { log_view.text = null }
	}

	private fun subscribeFlows() {
		lifecycleScope.launchWhenResumed { flowViewModel.sharedFlow.collect { log_view.log_view.appendText(it) } }
		lifecycleScope.launchWhenResumed { flowViewModel.stateFlow.collect { start_flow_state_button.text = it } }
	}
}