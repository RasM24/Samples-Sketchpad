package sample.endroad.coroutines.application

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

interface MessageSender {

	val messages: SharedFlow<String>
	fun printMessage(message: String)
}

class MessageSenderImpl : MessageSender {

	override val messages = MutableSharedFlow<String>(extraBufferCapacity = 100)

	override fun printMessage(message: String) {
		println(message)
		messages.tryEmit(message)
	}
}