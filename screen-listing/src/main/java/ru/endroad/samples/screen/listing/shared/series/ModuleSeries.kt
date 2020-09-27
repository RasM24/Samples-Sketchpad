package ru.endroad.samples.screen.listing.shared.series

import org.koin.dsl.module
import org.koin.experimental.builder.single
import org.koin.experimental.builder.singleBy

val moduleSeries = module {
	singleBy<SeriesDataSource, MockSeriesDataSource>()
	single<GetSeriesListUseCase>()
}