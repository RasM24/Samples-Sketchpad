package ru.endroad.samples.screen.listing.shared.promo

interface PromoDataSource {

	suspend fun get(): List<Promo>
}