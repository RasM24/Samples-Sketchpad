package ru.endroad.samples.screen.listing.shared.listing

import ru.endroad.samples.screen.listing.shared.listing.ListingItem.*
import ru.endroad.samples.screen.listing.shared.movies.Movie
import ru.endroad.samples.screen.listing.shared.promo.Promo
import ru.endroad.samples.screen.listing.shared.series.Series

class MakeItemListUseCase {

	//TODO правильнее присылать ресурсы для имен секций в параметрах. Однако в sample-приложении решил этим пренебречь
	private val sectionItemSeries = SectionItem("Сериалы")
	private val sectionItemMovies = SectionItem("Фильмы")

	operator fun invoke(
		movies: List<Movie>?,
		series: List<Series>?,
		promo: List<Promo>?
	): List<ListingItem> =
		mutableListOf<ListingItem>().apply {
			promo?.let(::PromoItem)?.let(::add)

			sectionItemSeries.let(::add)
			series?.map(::SeriesItem)?.let(::addAll)

			sectionItemMovies.let(::add)
			movies?.map(::MovieItem)?.let(::addAll)
		}
}