package sample.endroad.coroutines.flow

import androidx.lifecycle.ViewModel
import sample.endroad.coroutines.application.MessageSender
import sample.endroad.coroutines.application.MessageSenderImpl

class FlowViewModel : ViewModel(), MessageSender by MessageSenderImpl() {

}