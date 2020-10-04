package ru.endroad.samples.screen.listing.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_series.view.*
import ru.endroad.samples.screen.listing.R
import ru.endroad.samples.screen.listing.shared.listing.ListingItem
import ru.endroad.samples.screen.listing.shared.series.Series

class SeriesViewHolder(parent: ViewGroup) : ListingViewHolder(parent.inflate(R.layout.item_series)) {

	fun bind(item: ListingItem.SeriesItem) {
		itemView.bind(item.series)
	}

	private fun View.bind(series: Series) {
		name.text = series.name
		Picasso.get().load(series.posterUrl).fit().into(poster)
		rating.text = series.rating.toString()
		genre.text = series.genre.toString()
		country.text = series.country.toString()
		release_period.text = series.getReleasePeriod()
		episodes_counter.text = series.getEpisodesCounterText(itemView.context)
	}

	private fun Series.getReleasePeriod(): String =
		"$releaseYear - ${expirationYear ?: "н.в."}"

	private fun Series.getEpisodesCounterText(context: Context): String {
		val episodesText = context.resources.getQuantityString(R.plurals.plurals_episode_name, episodesCount, episodesCount)
		val seasonsText = context.resources.getQuantityString(R.plurals.plurals_season_name, seasonCount, seasonCount)

		return "$episodesText, $seasonsText"
	}
}