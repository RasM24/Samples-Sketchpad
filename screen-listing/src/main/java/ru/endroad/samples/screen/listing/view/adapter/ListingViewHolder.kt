package ru.endroad.samples.screen.listing.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class ListingViewHolder(view: View) : RecyclerView.ViewHolder(view)

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
	LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)