package ru.endroad.samples.screen.listing.shared.promo

class GetPromoUseCase(private val dataSource: PromoDataSource) {

	suspend operator fun invoke(): List<Promo> = dataSource.get()
}