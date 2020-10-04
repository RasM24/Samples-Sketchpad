package ru.endroad.samples.screen.listing.shared.promo.view

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

class CarouselViewPagerTransformer : ViewPager.PageTransformer {

	override fun transformPage(page: View, position: Float) {
		val alpha: Float
		val scale: Float
		val translationX: Float
		if (position >= -1 && position <= 1) {
			scale = MIN_SCALE_ZOOM.coerceAtLeast(1 - abs(position))
			alpha = MIN_ALPHA_ZOOM +
				(scale - MIN_SCALE_ZOOM) / (1 - MIN_SCALE_ZOOM) * (1 - MIN_ALPHA_ZOOM)
			val vMargin = page.height * (1 - scale) / 2
			val hMargin = page.width * (1 - scale) / 2
			translationX = if (position < 0) {
				hMargin - vMargin / 2
			} else {
				-hMargin + vMargin / 2
			}
		} else {
			alpha = 1f
			scale = 1f
			translationX = 0f
		}
		page.alpha = alpha
		page.translationX = translationX
		page.scaleX = scale
		page.scaleY = scale
	}

	companion object {
		private const val MIN_SCALE_ZOOM = 0.85f
		private const val MIN_ALPHA_ZOOM = 0.5f
	}
}