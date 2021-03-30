package ru.endroad.sample.screen.navigation.router.navigator

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import ru.endroad.sample.screen.navigation.router.command.RequireActivity

class NavigationCommandStack {

	private val sharedFlow = MutableSharedFlow<RequireActivity>(
		replay = Int.MAX_VALUE,
		extraBufferCapacity = 0,
		onBufferOverflow = BufferOverflow.SUSPEND,
	)

	val commandFlow: Flow<RequireActivity> = flow {
		sharedFlow.collect {
			sharedFlow.resetReplayCache()
			emit(it)
		}
	}

	fun execute(requireActivity: RequireActivity) {
		sharedFlow.tryEmit(requireActivity)
	}
}