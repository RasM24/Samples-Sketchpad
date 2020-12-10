package sample.endroad.coroutines.flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import sample.endroad.coroutines.application.MessageSender
import sample.endroad.coroutines.application.MessageSenderImpl
import kotlin.coroutines.CoroutineContext

class FlowViewModel : ViewModel(), MessageSender by MessageSenderImpl() {

	val sharedFlow = MutableSharedFlow<String>(extraBufferCapacity = 10)
	val stateFlow = MutableStateFlow("Initialized State")

	fun exampleSharedFlow() {
		viewModelScope.launch {
			sharedFlow.emit("first element")
			delay(2000)
			sharedFlow.emit("second element")
			delay(1000)
			sharedFlow.emit("third element")
		}
	}

	fun exampleStateFlow() {
		viewModelScope.launch {
			stateFlow.tryEmit("Loading State")
			delay(4000)
			stateFlow.tryEmit("Playing State")
			delay(2000)
			stateFlow.tryEmit("Pausa State")
		}
	}

}