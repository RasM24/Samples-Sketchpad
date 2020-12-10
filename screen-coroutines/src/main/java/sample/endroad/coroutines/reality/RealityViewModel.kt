package sample.endroad.coroutines.reality

import androidx.lifecycle.ViewModel
import sample.endroad.coroutines.application.MessageSender
import sample.endroad.coroutines.application.MessageSenderImpl
import sample.endroad.coroutines.reality.data.GithubDataSource

class RealityViewModel(
	private val dataSource: GithubDataSource
) : ViewModel(), MessageSender by MessageSenderImpl() {

	fun fetchRepositories() {

	}

	fun sendPrivateRequest() {

	}
}