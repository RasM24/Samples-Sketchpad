package ru.endroad.samples.screen.listing.view

import kotlinx.android.synthetic.main.fragment_listing.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.component.core.MviFragment
import ru.endroad.samples.screen.listing.R
import ru.endroad.samples.screen.listing.view.adapter.ListingAdapter

class ListingFragment : MviFragment<ListingScreenState, ListingScreenEvent>() {

	override val layout = R.layout.fragment_listing

	override val viewModel by viewModel<ListingViewModel>()

	private val adapter = ListingAdapter()

	override fun setupViewComponents() {
		list.adapter = adapter
	}

	override fun render(state: ListingScreenState) {
		when (state) {
			ListingScreenState.Initialized   -> Unit
			is ListingScreenState.DataLoaded -> adapter.items = state.items
		}
	}
}