package ru.endroad.sample.screen.navigation.feature.colored.blue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter
import ru.endroad.sample.screen.navigation.feature.colored.ColoredView
import ru.endroad.sample.screen.navigation.feature.colored.getBackStackStringFormatted
import ru.endroad.sample.screen.navigation.migrate.composeFragmentView

class BlueFragment : Fragment() {

	private val router: ColoredRouter by inject()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		composeFragmentView {
			ColoredView(
				sceneName = this.getBackStackStringFormatted(),
				color = Color.Blue,
				replaceScene = router::replaceMagentaScreen,
				openScene = router::openMagentaScreen,
			)
		}
}