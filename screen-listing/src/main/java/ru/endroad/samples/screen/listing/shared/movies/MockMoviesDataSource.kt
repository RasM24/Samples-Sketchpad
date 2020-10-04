package ru.endroad.samples.screen.listing.shared.movies

class MockMoviesDataSource : MoviesDataSource {

	override suspend fun get(): List<Movie> = allFilmList
}