package sample.endroad.coroutines.coroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import sample.endroad.coroutines.application.MessageSender
import sample.endroad.coroutines.application.MessageSenderImpl
import kotlin.coroutines.CoroutineContext

class CoroutineViewModel : ViewModel(), MessageSender by MessageSenderImpl() {

	fun exampleSuspendFunction() {
		viewModelScope.launch {
			mockSuspendFunction(::printMessage)
		}
	}

	private val coroutineFailureHandler = CoroutineExceptionHandler { coroutineContext: CoroutineContext, throwable: Throwable ->
		printMessage(throwable.toString())
	}

	fun exampleFailureHandler() {
		viewModelScope.launch(coroutineFailureHandler) {
			mockErrorFunction(::printMessage)
			printMessage("Если мы дошли до этой точки, значит CoroutineExceptionHandler сработал неправильно")
		}
	}

	fun exampleAsyncFunction() {
		viewModelScope.launch {
			val data = getDataAsync()
			printMessage("coroutine is resumed")
			printMessage("wait response: ${data.await()}")
		}
	}

	private fun CoroutineScope.getDataAsync(): Deferred<String> =
		async { mockLoadData(::printMessage) }

	fun exampleFlowFromElements() {
		val numbersFlow = flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
			.printElements { "start flow with: $it" }
			.filter { (it % 2) != 0 }
			.printElements { "filter elements: $it" }
			.map { it * it }
			.onEach { printMessage("map element: $it") }
			.take(3)

		viewModelScope.launch {
			printMessage("start coroutine")
			numbersFlow.collect { printMessage("collect element: $it") }
		}
	}

	fun exampleFlowWithException() {
		val numbersFlow = flowOf(1, 2, null, 4, null, null, 7, 8, 9, 10)
			.printElements { "start flow with: $it" }
			.map { requireNotNull(it) { "element is null" } }
			.filter { (it % 2) != 0 }
			.printElements { "filter elements: $it" }
			.map { it * it }
			.onEach { printMessage("map element: $it") }
			.take(3)

		viewModelScope.launch(coroutineFailureHandler) {
			printMessage("start coroutine")
			numbersFlow.collect { printMessage("collect element: $it") }
		}
	}

	private fun <T> Flow<T>.printElements(getMessage: suspend (T) -> String): Flow<T> = flow {
		collect { value ->
			printMessage(getMessage(value))
			emit(value)
		}
	}
}