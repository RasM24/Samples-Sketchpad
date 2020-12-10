package sample.endroad.coroutines.reality.data

class GithubDataSource(
	private val api: GithubApi,
) {

	suspend fun searchUser(query: String) =
		api.searchUser(query)

	suspend fun getRepositories(user: String) =
		api.getRepositories(user)
}