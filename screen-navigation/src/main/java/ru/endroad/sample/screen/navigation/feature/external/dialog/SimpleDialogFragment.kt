package ru.endroad.sample.screen.navigation.feature.external.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.simple_dialog_fragment.*
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.utils.withArguments

class SimpleDialogFragment : AppCompatDialogFragment() {

	companion object {

		private const val TOOLBAR_TEXT_KEY = "TITLE_SCREEN"
		private const val MESSAGE_KEY = "MESSAGE_SCREEN"

		fun create(toolbarText: String, message: String): DialogFragment =
			SimpleDialogFragment().withArguments(
				TOOLBAR_TEXT_KEY to toolbarText,
				MESSAGE_KEY to message,
			)
	}

	private val toolbarText: String
		get() = requireArguments().getString(TOOLBAR_TEXT_KEY).let(::requireNotNull)

	private val message: String
		get() = requireArguments().getString(MESSAGE_KEY).let(::requireNotNull)

	private val toolbar: Toolbar?
		get() = view?.findViewById(R.id.toolbar)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(R.layout.simple_dialog_fragment, container, false)

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		toolbar?.title = toolbarText
		text_dialog.text = message

		ok_dialog_button.setOnClickListener { dismiss() }
	}
}