package ru.endroad.samples.screen.listing.shared.promo

import org.koin.dsl.module
import org.koin.experimental.builder.single
import org.koin.experimental.builder.singleBy

val modulePromo = module {
	singleBy<PromoDataSource, MockPromoDataSource>()
	single<GetPromoUseCase>()
}