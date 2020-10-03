package ru.endroad.samples.screen.listing.shared.promo

class MockPromoDataSource : PromoDataSource {

	private val aviasalesPromo = Promo("Aviasales", "Самая")
	private val azinoPromo = Promo("azino777", "Бесячая")
	private val oneXBetPromo = Promo("1xBet", "Реклама")

	override suspend fun get(): List<Promo> =
		listOf(
			aviasalesPromo,
			azinoPromo,
			oneXBetPromo
		)
}