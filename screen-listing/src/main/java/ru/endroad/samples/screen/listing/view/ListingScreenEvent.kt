package ru.endroad.samples.screen.listing.view

sealed class ListingScreenEvent {
	object FetchData : ListingScreenEvent()
}