package sample.endroad.coroutines.coroutine

import androidx.lifecycle.ViewModel
import sample.endroad.coroutines.application.MessageSender
import sample.endroad.coroutines.application.MessageSenderImpl

class CoroutineViewModel : ViewModel(), MessageSender by MessageSenderImpl() {

}