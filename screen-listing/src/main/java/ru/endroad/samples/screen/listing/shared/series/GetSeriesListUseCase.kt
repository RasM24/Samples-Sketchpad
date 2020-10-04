package ru.endroad.samples.screen.listing.shared.series

class GetSeriesListUseCase(private val dataSource: SeriesDataSource) {

	suspend operator fun invoke(): List<Series> = dataSource.get()
}