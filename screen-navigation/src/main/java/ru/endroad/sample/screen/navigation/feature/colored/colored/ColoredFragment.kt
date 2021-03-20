package ru.endroad.sample.screen.navigation.feature.colored.colored

import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.colored_fragment.*
import org.koin.android.ext.android.inject
import ru.endroad.component.core.CampFragment
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter

class ColoredFragment : CampFragment() {

	override val layout = R.layout.colored_fragment

	private val router: ColoredRouter by inject()

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.title_colored))

		replace_button.isVisible = false
		open_button.setOnClickListener { router.openGreenScreen() }
	}
}