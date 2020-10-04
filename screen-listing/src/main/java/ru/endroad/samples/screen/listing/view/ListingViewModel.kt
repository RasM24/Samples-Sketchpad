package ru.endroad.samples.screen.listing.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import ru.endroad.libraries.mvi.core.viewmodel.PresenterMvi
import ru.endroad.samples.screen.listing.shared.listing.MakeItemListUseCase
import ru.endroad.samples.screen.listing.shared.movies.GetMoviesUseCase
import ru.endroad.samples.screen.listing.shared.promo.GetPromoUseCase
import ru.endroad.samples.screen.listing.shared.series.GetSeriesListUseCase

class ListingViewModel(
	private val makeItemList: MakeItemListUseCase,
	private val getMovies: GetMoviesUseCase,
	private val getSeriesList: GetSeriesListUseCase,
	private val getPromo: GetPromoUseCase
) : PresenterMvi<ListingScreenState, ListingScreenEvent>, ViewModel() {

	override val state = MutableLiveData<ListingScreenState>()

	init {
		reduce(ListingScreenEvent.FetchData())
	}

	override fun reduce(event: ListingScreenEvent) {
		viewModelScope.launch {
			when (event) {
				is ListingScreenEvent.FetchData -> state.value = event.reduce()
			}
		}
	}

	private suspend fun ListingScreenEvent.FetchData.reduce(): ListingScreenState {
		val movies = viewModelScope.async { getMovies() }
		val series = viewModelScope.async { getSeriesList() }
		val promo = viewModelScope.async { getPromo() }

		val itemList = makeItemList(movies = movies.await(), series = series.await(), promo = promo.await())
		return ListingScreenState.DataLoaded(itemList)
	}
}