package ru.endroad.samples.screen.listing.shared.movies

class GetMoviesUseCase(private val moviesDataSource: MoviesDataSource) {

	suspend operator fun invoke(): List<Movie> = moviesDataSource.get()
}