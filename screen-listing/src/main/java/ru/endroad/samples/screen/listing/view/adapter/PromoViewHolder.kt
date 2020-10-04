package ru.endroad.samples.screen.listing.view.adapter

import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_promo.view.*
import ru.endroad.samples.screen.listing.R
import ru.endroad.samples.screen.listing.shared.listing.ListingItem

class PromoViewHolder(viewParent: ViewGroup) : ListingViewHolder(viewParent.inflate(R.layout.item_promo)) {

	fun bind(item: ListingItem.PromoItem) {
		itemView.carouselView.setPromoList(item.promo)
	}


//		carouselView.setViewListener
//	{
//		position ->
//		viewParent.inflate(R.layout.item_carusel_promo).apply {
//			promo_title.text = promo[position].title
//			promo_description.text = promo[position].description
//
//		}
//	}
}