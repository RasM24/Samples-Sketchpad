package sample.endroad.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CoroutineTest {

	@Test
	fun launchCoroutines() = runBlocking {
		println("first checkpoint")
		launch {
			delay(1000)
			println("coroutine first checkpoint")
		}
		launch {
			println("coroutine second checkpoint")
		}
		println("second checkpoint")
	}
}