package ru.endroad.samples.screen.listing.view.adapter

import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movies.view.*
import ru.endroad.samples.screen.listing.R
import ru.endroad.samples.screen.listing.shared.listing.ListingItem
import ru.endroad.samples.screen.listing.shared.movies.Movie

class MoviesViewHolder(parent: ViewGroup) : ListingViewHolder(parent.inflate(R.layout.item_movies)) {

	fun bind(item: ListingItem.MovieItem) {
		itemView.bind(item.movie)
	}

	private fun View.bind(movie: Movie) {
		name.text = movie.name
		Picasso.get().load(movie.posterUrl).fit().into(poster)
		rating.text = movie.rating.toString()
		genre.text = movie.genre.toString()
		country.text = movie.country.toString()
		release_year.text = movie.releaseYear.toString()
	}
}