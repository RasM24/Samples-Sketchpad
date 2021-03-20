package ru.endroad.samples.screen.listing.view

import kotlinx.android.synthetic.main.fragment_listing.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.component.core.CampFragment
import ru.endroad.libraries.mvi.core.view.MviView
import ru.endroad.samples.screen.listing.R
import ru.endroad.samples.screen.listing.view.adapter.ListingAdapter

class ListingFragment : CampFragment(), MviView<ListingScreenState, ListingScreenEvent> {

	override val layout = R.layout.fragment_listing

	override val presenter by viewModel<ListingViewModel>()

	private val adapter = ListingAdapter()

	override fun setupViewComponents() {
		bindRenderState(this)
		list.adapter = adapter
	}

	override fun render(state: ListingScreenState) {
		when (state) {
			is ListingScreenState.DataLoaded -> adapter.items = state.items
		}
	}
}