package ru.endroad.samples.screen.listing.shared.movies

interface MoviesDataSource {

	suspend fun get(): List<Movie>
}