package ru.endroad.samples.screen.game.shared.animal

class Hunger(private val durationOfHungry: Int) {

	private var gestationalAge = 1

	fun proceed() {
		gestationalAge++
	}

	fun isHunger(): Boolean =
		gestationalAge >= durationOfHungry

	fun feeding() {
		gestationalAge = 0
	}
}