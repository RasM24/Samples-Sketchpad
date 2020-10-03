package ru.endroad.samples.screen.listing.shared.listing

import ru.endroad.samples.screen.listing.shared.movies.Movie
import ru.endroad.samples.screen.listing.shared.promo.Promo
import ru.endroad.samples.screen.listing.shared.series.Series

sealed class ListingItem {
	data class PromoItem(val promo: List<Promo>) : ListingItem()
	data class MovieItem(val movie: Movie) : ListingItem()
	data class SeriesItem(val series: Series) : ListingItem()
	data class SectionItem(val title: String) : ListingItem()
}