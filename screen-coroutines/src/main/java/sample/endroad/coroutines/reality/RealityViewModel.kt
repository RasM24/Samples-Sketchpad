package sample.endroad.coroutines.reality

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import sample.endroad.coroutines.application.MessageSender
import sample.endroad.coroutines.application.MessageSenderImpl
import sample.endroad.coroutines.reality.data.GithubDataSource
import sample.endroad.coroutines.reality.data.GuruDataSource
import sample.endroad.coroutines.reality.model.GithubRepository

class RealityViewModel(
	private val guruDataSource: GuruDataSource,
	private val dataSource: GithubDataSource,
) : ViewModel(), MessageSender by MessageSenderImpl() {

	fun fetchRepositories() {
		viewModelScope.launch(exceptionHandler) {
			val user = dataSource.searchUser("Rasm24").items.first()
			val repositories = dataSource.getRepositories(user.login).map(GithubRepository::name)

			printMessage(repositories.joinToString("\n"))
		}
	}

	fun sendPrivateRequest() {
		viewModelScope.launch(exceptionHandler) {
			val series = guruDataSource.browseSeries()

			printMessage(series)
		}
	}

	private val exceptionHandler = CoroutineExceptionHandler { context, throwable ->
		printMessage(throwable.message ?: throwable.toString())
	}
}