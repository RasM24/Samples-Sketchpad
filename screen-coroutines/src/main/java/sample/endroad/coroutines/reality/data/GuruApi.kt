package sample.endroad.coroutines.reality.data

import retrofit2.http.GET

interface GuruApi {

	@GET("browse")
	suspend fun browseSeries(): String
}