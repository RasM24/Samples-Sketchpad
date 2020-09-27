package ru.endroad.samples.screen.listing.view

import ru.endroad.samples.screen.listing.shared.listing.ListingItem

sealed class ListingScreenState {
	data class DataLoaded(val items: List<ListingItem>) : ListingScreenState()
}