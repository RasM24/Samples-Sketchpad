package sample.endroad.coroutines.coroutine

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.coroutine_activity.*
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import sample.endroad.coroutines.R
import sample.endroad.coroutines.application.appendText

class CoroutineActivity : AppCompatActivity() {

	private val coroutineViewModel: CoroutineViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.coroutine_activity)

		setupViewComponent()
		subscribeMessages { message -> log_view.appendText(message) }
	}

	private fun setupViewComponent() {
		button_start_successful_coroutine.setOnClickListener { coroutineViewModel.exampleSuspendFunction() }
		button_start_coroutine_with_exception.setOnClickListener { coroutineViewModel.exampleFailureHandler() }
		button_start_async_function.setOnClickListener { coroutineViewModel.exampleAsyncFunction() }
		start_flow_button.setOnClickListener { coroutineViewModel.exampleFlowFromElements() }
		start_flow_with_exception_button.setOnClickListener { coroutineViewModel.exampleFlowWithException() }

		button_clear_log.setOnClickListener { log_view.text = null }
	}

	private fun subscribeMessages(messageListener: (String) -> Unit) {
		lifecycleScope.launchWhenResumed { coroutineViewModel.messages.collect { messageListener(it) } }
	}
}