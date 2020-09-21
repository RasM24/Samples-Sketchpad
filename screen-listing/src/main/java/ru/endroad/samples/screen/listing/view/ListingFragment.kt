package ru.endroad.samples.screen.listing.view

import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.libraries.camp.fragment.CampFragment
import ru.endroad.libraries.mvi.core.view.MviView
import ru.endroad.samples.screen.listing.R

class ListingFragment : CampFragment(), MviView<ListingScreenState, ListingScreenEvent> {

	override val layout = R.layout.fragment_listing

	override val presenter by viewModel<ListingViewModel>()

	override fun setupViewComponents() {
		bindRenderState(this)
	}

	override fun render(state: ListingScreenState) = Unit
}