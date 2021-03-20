package ru.endroad.component.core

import kotlinx.coroutines.flow.StateFlow

interface MviViewModel<STATE, EVENT> {

	val state: StateFlow<STATE>

	fun notice(event: EVENT)
}