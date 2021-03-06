package ru.endroad.samples.screen.listing.view.adapter

import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_section.view.*
import ru.endroad.samples.screen.listing.R
import ru.endroad.samples.screen.listing.shared.listing.ListingItem

class SectionViewHolder(parent: ViewGroup) : ListingViewHolder(parent.inflate(R.layout.item_section)) {

	fun bind(item: ListingItem.SectionItem) {
		itemView.section_title.text = item.title
	}
}