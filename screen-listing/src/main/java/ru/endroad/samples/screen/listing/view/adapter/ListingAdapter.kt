package ru.endroad.samples.screen.listing.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.endroad.samples.screen.listing.shared.listing.ListingItem
import ru.endroad.samples.screen.listing.shared.listing.ListingItem.*

class ListingAdapter : RecyclerView.Adapter<ListingViewHolder>() {

	private companion object {
		const val PROMO_VIEW_TYPE = 1
		const val MOVIE_VIEW_TYPE = 2
		const val SERIES_VIEW_TYPE = 3
		const val SECTION_VIEW_TYPE = 4
	}

	var items: List<ListingItem> = listOf()
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder =
		when (viewType) {
			PROMO_VIEW_TYPE   -> PromoViewHolder(parent)
			MOVIE_VIEW_TYPE   -> MoviesViewHolder(parent)
			SERIES_VIEW_TYPE  -> SeriesViewHolder(parent)
			SECTION_VIEW_TYPE -> SectionViewHolder(parent)
			else              -> throw IllegalStateException("Отсутствует ViewHolder для данного viewType")
		}

	override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
		when (holder) {
			is PromoViewHolder   -> holder.bind(items[position] as PromoItem)
			is MoviesViewHolder  -> holder.bind(items[position] as MovieItem)
			is SeriesViewHolder  -> holder.bind(items[position] as SeriesItem)
			is SectionViewHolder -> holder.bind(items[position] as SectionItem)
			else                 -> throw IllegalStateException("Отсутствует binding для ${holder::class}")
		}
	}

	override fun getItemViewType(position: Int): Int =
		when (items[position]) {
			is PromoItem   -> PROMO_VIEW_TYPE
			is MovieItem   -> MOVIE_VIEW_TYPE
			is SeriesItem  -> SERIES_VIEW_TYPE
			is SectionItem -> SECTION_VIEW_TYPE
		}

	override fun getItemCount(): Int =
		items.size
}