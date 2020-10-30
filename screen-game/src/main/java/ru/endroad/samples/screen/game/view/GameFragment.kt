package ru.endroad.samples.screen.game.view

import kotlinx.android.synthetic.main.game_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.libraries.camp.fragment.CampFragment
import ru.endroad.samples.screen.game.R

class GameFragment : CampFragment() {

	override val layout = R.layout.game_fragment

	private val viewModel: GameViewModel by viewModel()

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.title_game))

		end_turn.setOnClickListener { viewModel.endTurn() }
	}
}