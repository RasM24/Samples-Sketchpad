package ru.endroad.samples.screen.listing.shared.movies

import org.koin.dsl.module
import org.koin.experimental.builder.single
import org.koin.experimental.builder.singleBy

val moduleMovies = module {
	singleBy<MoviesDataSource, MockMoviesDataSource>()
	single<GetMoviesUseCase>()
}