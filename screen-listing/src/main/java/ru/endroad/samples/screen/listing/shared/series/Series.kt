package ru.endroad.samples.screen.listing.shared.series

import ru.endroad.samples.screen.listing.shared.metadata.Country
import ru.endroad.samples.screen.listing.shared.metadata.Genre

data class Series(
	val name: String,
	val posterUrl: String,
	val rating: Float,
	val genre: List<Genre>,
	val country: List<Country>,
	val releaseYear: Long,
	val expirationYear: Long?,
	val seasonCount: Int,
	val episodesCount: Int
)