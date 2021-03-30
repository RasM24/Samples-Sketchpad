package ru.endroad.sample.screen.navigation.feature.colored.red

import android.graphics.Color
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.colored_fragment.*
import ru.endroad.component.core.CampFragment
import ru.endroad.sample.screen.navigation.R
import ru.endroad.sample.screen.navigation.feature.colored.getBackStackStringFormatted

class RedFragment : CampFragment() {

	override val layout = R.layout.colored_fragment

	override fun setupViewComponents() {
		colored_content.setBackgroundColor(Color.RED)
		colored_text.text = this.getBackStackStringFormatted()

		replace_button.isVisible = false
		open_button.isVisible = false
	}
}