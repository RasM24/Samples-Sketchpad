package ru.endroad.sample.screen.navigation.feature.colored.blue

import android.graphics.Color
import kotlinx.android.synthetic.main.colored_fragment.*
import org.koin.android.ext.android.inject
import ru.endroad.component.core.CampFragment
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.feature.colored.ColoredRouter
import ru.endroad.sample.screen.navigation.feature.colored.getBackStackStringFormatted

class BlueFragment : CampFragment() {

	override val layout = R.layout.colored_fragment

	private val router: ColoredRouter by inject()

	override fun setupViewComponents() {
		colored_content.setBackgroundColor(Color.BLUE)
		colored_text.text = this.getBackStackStringFormatted()

		replace_button.setOnClickListener { router.replaceMagentaScreen() }
		open_button.setOnClickListener { router.openMagentaScreen() }
	}
}