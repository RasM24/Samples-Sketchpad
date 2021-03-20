package ru.endroad.component.core

import android.view.View

fun showViews(vararg views: View) = views.forEach { it.visibility = View.VISIBLE }

fun hideViews(vararg views: View) = views.forEach { it.visibility = View.GONE }
