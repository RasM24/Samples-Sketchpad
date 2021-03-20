package ru.endroad.samples.screen.game.view

import kotlinx.android.synthetic.main.menu_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.component.core.CampFragment
import ru.endroad.samples.screen.game.R

class MenuFragment : CampFragment() {

	override val layout = R.layout.menu_fragment

	private val viewModel: MenuViewModel by viewModel()

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.title_menu))
		start_button.setOnClickListener { viewModel.startGame() }
	}
}