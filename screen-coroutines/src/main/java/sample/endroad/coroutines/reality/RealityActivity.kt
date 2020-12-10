package sample.endroad.coroutines.reality

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.reality_activity.*
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import sample.endroad.coroutines.R

class RealityActivity : AppCompatActivity() {

	private val viewModel: RealityViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.reality_activity)

		setupViewComponent()
	}

	private fun setupViewComponent() {
		fetch_repositories_button.setOnClickListener { viewModel.fetchRepositories() }
		send_private_request.setOnClickListener { viewModel.sendPrivateRequest() }

		button_clear_log.setOnClickListener { log_view.text = null }
		lifecycleScope.launchWhenResumed { viewModel.messages.collect { log_view.text = it } }
	}
}