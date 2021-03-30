package ru.endroad.sample.screen.navigation.feature.colored.colored

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter
import ru.endroad.sample.screen.navigation.feature.colored.ColoredView
import ru.endroad.sample.screen.navigation.feature.colored.getBackStackStringFormatted
import ru.endroad.sample.screen.navigation.migrate.composeFragmentView

class ColoredFragment : Fragment() {

	private val router: ColoredRouter by inject()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		requireActivity().title = getString(R.string.title_colored)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		composeFragmentView {
			ColoredView(
				sceneName = this.getBackStackStringFormatted(),
				color = Color.LightGray,
				replaceScene = null,
				openScene = router::openGreenScreen,
			)
		}
}