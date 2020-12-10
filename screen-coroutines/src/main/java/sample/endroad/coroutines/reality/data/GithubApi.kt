package sample.endroad.coroutines.reality.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import sample.endroad.coroutines.reality.model.GithubRepository
import sample.endroad.coroutines.reality.model.GithubSearchResult

interface GithubApi {

	@GET("search/users")
	suspend fun searchUser(@Query("q") query: String): GithubSearchResult

	@GET("users/{user}/repos")
	suspend fun getRepositories(@Path("user") user: String): List<GithubRepository>
}