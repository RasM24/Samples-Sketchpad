package ru.endroad.samples.screen.game.shared.generation

import ru.endroad.samples.screen.game.shared.animal.Animal
import ru.endroad.samples.screen.game.shared.animal.Grampus
import ru.endroad.samples.screen.game.shared.animal.Penguin
import kotlin.reflect.KClass

class AnimalFactory(
	private val uniqueIdRepository: UniqueIdRepository,
) {

	fun <T : Animal> create(kClass: KClass<out T>): Animal? =
		when (kClass) {
			Penguin::class -> createPenguin()
			Grampus::class -> createGrampus()
			else           -> null
		}

	private fun createPenguin(): Penguin =
		Penguin(
			uniqueIdRepository.get(),
		)

	private fun createGrampus(): Grampus =
		Grampus(
			uniqueIdRepository.get(),
		)
}