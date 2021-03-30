package ru.endroad.sample.screen.navigation.feature.alphabet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.migrate.composeFragmentView

class AlphabetFragment : Fragment() {

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		requireActivity().title = getString(R.string.title_alphabet)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		composeFragmentView {
			Box(modifier = Modifier.fillMaxSize()) {
				Text(text = stringResource(id = R.string.alphabet_stub_text))
			}
		}
}