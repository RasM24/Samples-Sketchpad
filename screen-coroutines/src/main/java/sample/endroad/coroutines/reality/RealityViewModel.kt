package sample.endroad.coroutines.reality

import androidx.lifecycle.ViewModel
import sample.endroad.coroutines.application.MessageSender
import sample.endroad.coroutines.application.MessageSenderImpl

class RealityViewModel : ViewModel(), MessageSender by MessageSenderImpl() {

}