package sample.endroad.coroutines.reality.model

data class GithubSearchResult(val total_count: Int, val incomplete_results: Boolean, val items: List<GithubUser>)