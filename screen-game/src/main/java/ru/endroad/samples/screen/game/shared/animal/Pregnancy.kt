package ru.endroad.samples.screen.game.shared.animal

class Pregnancy(private val durationOfPregnancy: Int) {

	private var gestationalAge = 1

	fun proceed() {
		gestationalAge++
	}

	fun isChildbirth(): Boolean =
		gestationalAge >= durationOfPregnancy

	fun cancel() {
		gestationalAge = 0
	}
}