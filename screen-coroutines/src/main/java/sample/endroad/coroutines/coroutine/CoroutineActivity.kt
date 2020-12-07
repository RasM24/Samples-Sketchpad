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

		subscribeMessages { }
	}

	private fun subscribeMessages(messageListener: (String) -> Unit) {
		lifecycleScope.launchWhenResumed { coroutineViewModel.messages.collect { messageListener(it) } }
	}
}