package sample.endroad.coroutines.coroutine

import kotlinx.coroutines.delay

suspend fun mockSuspendFunction(printMessage: (String) -> Unit) {
	printMessage("start suspend function")
	delay(1000)
	printMessage("end suspend function")
}

suspend fun mockErrorFunction(printMessage: (String) -> Unit) {
	printMessage("start function with exception")
	delay(1000)
	throw RuntimeException("Throw error in suspend function")
}

suspend fun mockLoadData(printMessage: (String) -> Unit): String {
	printMessage("start api response")
	delay(2000)
	return "Api response"
}