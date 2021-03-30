package ru.endroad.sample.screen.navigation.feature.colored.red

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import ru.endroad.sample.screen.navigation.feature.colored.ColoredView
import ru.endroad.sample.screen.navigation.feature.colored.getBackStackStringFormatted
import ru.endroad.sample.screen.navigation.migrate.composeFragmentView

class RedFragment : Fragment() {

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		composeFragmentView {
			ColoredView(
				sceneName = this.getBackStackStringFormatted(),
				color = Color.Red,
				replaceScene = null,
				openScene = null,
			)
		}
}