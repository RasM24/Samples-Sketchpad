package ru.endroad.samples.screen.listing.shared.promo.view

import android.content.Context
import android.util.AttributeSet
import android.widget.RemoteViews.RemoteView
import androidx.viewpager.widget.ViewPager
import ru.endroad.samples.screen.listing.shared.promo.Promo
import java.util.*

@RemoteView
//TODO костыльное решение чисто для примера. Скопировано просто с рандомного проекта на github и сильно отрефачено
class CarouselView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null
) : ViewPager(context, attrs) {

	private var slideInterval = 3000

	private var swipeTimer: Timer = Timer()
	private var swipeTask: SwipeTask = SwipeTask()
	private val carouselPagerAdapter = CarouselPagerAdapter()

	init {
		playCarousel()
		setPageTransformer(true, CarouselViewPagerTransformer())
	}

	fun setPromoList(promoList: List<Promo>) {
		carouselPagerAdapter.promoList = promoList
		adapter = carouselPagerAdapter

		offscreenPageLimit = promoList.size
		playCarousel()
	}

	private fun playCarousel() {
		resetScrollTimer()
		adapter?.let {
			if (slideInterval > 0 && it.count > 1) {
				swipeTimer.schedule(swipeTask, slideInterval.toLong(), slideInterval.toLong())
			}
		}
	}

	private fun resetScrollTimer() {
		swipeTimer.cancel()
		swipeTask.cancel()

		swipeTask = SwipeTask()
		swipeTimer = Timer()
	}

	private inner class SwipeTask : TimerTask() {
		override fun run() {
			post {
				val nextPage = (currentItem + 1) % carouselPagerAdapter.count
				setCurrentItem(nextPage, 0 != nextPage)
			}
		}
	}
}