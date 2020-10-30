package ru.endroad.samples.screen.game.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.endroad.samples.screen.game.shared.board.Field
import ru.endroad.samples.screen.game.shared.board.Subject
import ru.endroad.samples.screen.game.shared.generation.GenerateWorldUseCase

class GameViewModel(
	generateWorld: GenerateWorldUseCase,
) : ViewModel() {

	private val gameBoard = generateWorld()
	val field: MutableLiveData<Field<Subject?>> = MutableLiveData()

	init {
		field.value = gameBoard.getField()
	}

	fun endTurn() {
		field.value = gameBoard.getField()
	}
}