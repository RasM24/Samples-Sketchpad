package ru.endroad.samples.screen.listing.shared.series

class MockSeriesDataSource : SeriesDataSource {

	override suspend fun get(): List<Series> = allSeriesList
}