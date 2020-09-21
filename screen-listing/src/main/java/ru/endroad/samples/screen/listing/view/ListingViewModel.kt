package ru.endroad.samples.screen.listing.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.endroad.libraries.mvi.core.viewmodel.PresenterMvi

class ListingViewModel(

) : PresenterMvi<ListingScreenState, ListingScreenEvent>, ViewModel() {

	override val state = MutableLiveData<ListingScreenState>()

	override fun reduce(event: ListingScreenEvent) = Unit
}