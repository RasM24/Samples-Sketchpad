package ru.endroad.samples.screen.listing.shared.promo.view

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import ru.endroad.samples.screen.listing.shared.promo.Promo

class CarouselPagerAdapter : PagerAdapter() {

		var promoList: List<Promo> = listOf()
			set(value) {
				field = value
				notifyDataSetChanged()
			}

		override fun instantiateItem(collection: ViewGroup, position: Int): View =
			PromoViewHolder(promoList[position], collection)
				.apply(collection::addView)

		override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
			collection.removeView(view as View)
		}

		override fun isViewFromObject(view: View, `object`: Any): Boolean {
			return view === `object`
		}

		override fun getCount(): Int =
			promoList.size
	}