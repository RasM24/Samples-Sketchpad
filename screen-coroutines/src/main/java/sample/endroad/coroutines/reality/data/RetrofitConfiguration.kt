package sample.endroad.coroutines.reality.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val GITHUB_SERVER_URL = "https://api.github.com"
private const val GURU_SERVER_URL = "https://api.episodes.guru"

val logging get() = HttpLoggingInterceptor().apply { HttpLoggingInterceptor.Level.BODY }
val httpClient get() = OkHttpClient.Builder().apply { addInterceptor(logging) }

fun buildGithubRetrofit(): Retrofit =
	Retrofit.Builder()
		.baseUrl(GITHUB_SERVER_URL)
		.addConverterFactory(GsonConverterFactory.create())
		.client(httpClient.build())
		.build()

fun buildGuruRetrofit(): Retrofit =
	Retrofit.Builder()
		.baseUrl(GURU_SERVER_URL)
		.addConverterFactory(GsonConverterFactory.create())
		.client(httpClient.build())
		.build()