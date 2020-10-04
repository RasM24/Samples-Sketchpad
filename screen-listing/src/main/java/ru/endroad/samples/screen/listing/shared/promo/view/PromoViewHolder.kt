package ru.endroad.samples.screen.listing.shared.promo.view

import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_carusel_promo.view.*
import ru.endroad.samples.screen.listing.R
import ru.endroad.samples.screen.listing.shared.promo.Promo
import ru.endroad.samples.screen.listing.view.adapter.inflate

object PromoViewHolder {

	operator fun invoke(promo: Promo, viewParent: ViewGroup): View =
		viewParent.inflate(R.layout.item_carusel_promo).apply {
			promo_title.text = promo.title
			promo_description.text = promo.description
		}
}