package ru.endroad.samples.screen.listing.shared.listing

import ru.endroad.samples.screen.listing.shared.listing.ListingItem.*
import ru.endroad.samples.screen.listing.shared.movies.Movie
import ru.endroad.samples.screen.listing.shared.promo.Promo
import ru.endroad.samples.screen.listing.shared.series.Series

class MakeItemListUseCase {

	operator fun invoke(
		movies: List<Movie>?,
		series: List<Series>?,
		promo: Promo?
	): List<ListingItem> =
		mutableListOf<ListingItem>().apply {
			promo?.let(::PromoItem)?.let(::add)
			series?.map(::SeriesItem)?.let(::addAll)
			movies?.map(::MovieItem)?.let(::addAll)
		}
}