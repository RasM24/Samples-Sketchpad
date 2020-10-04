package ru.endroad.samples.screen.listing.shared.movies

import ru.endroad.samples.screen.listing.shared.metadata.Country
import ru.endroad.samples.screen.listing.shared.metadata.Genre

data class Movie(
	val name: String,
	val posterUrl: String,
	val rating: Float,
	val genre: List<Genre>,
	val country: List<Country>,
	val releaseYear: Long
)