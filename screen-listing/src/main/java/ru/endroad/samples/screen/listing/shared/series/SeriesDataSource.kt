package ru.endroad.samples.screen.listing.shared.series

interface SeriesDataSource {

	suspend fun get(): List<Series>
}