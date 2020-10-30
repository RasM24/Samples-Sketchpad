package ru.endroad.samples.screen.game.shared.generation

import ru.endroad.samples.screen.game.shared.animal.*
import kotlin.reflect.KClass

class AnimalFactory(
	private val uniqueIdRepository: UniqueIdRepository,
) {

	private companion object {

		const val DURATION_OF_HUNGER_GRAMPUS = 3
		const val DURATION_OF_PREGNANCY_GRAMPUS = 8
		const val DURATION_OF_PREGNANCY_PENGUIN = 8
	}

	fun <T : Animal> create(kClass: KClass<out T>): Animal? =
		when (kClass) {
			Penguin::class -> createPenguin()
			Grampus::class -> createGrampus()
			else           -> null
		}

	private fun createPenguin(): Penguin =
		Penguin(
			uniqueIdRepository.get(),
			Pregnancy(DURATION_OF_PREGNANCY_PENGUIN)
		)

	private fun createGrampus(): Grampus =
		Grampus(
			uniqueIdRepository.get(),
			Pregnancy(DURATION_OF_PREGNANCY_GRAMPUS),
			Hunger(DURATION_OF_HUNGER_GRAMPUS)
		)
}