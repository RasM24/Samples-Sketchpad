package sample.endroad.coroutines.reality.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val SERVER_URL = "https://api.github.com"

val logging get() = HttpLoggingInterceptor().apply { HttpLoggingInterceptor.Level.BODY }
val httpClient get() = OkHttpClient.Builder().apply { addInterceptor(logging) }

fun buildRetrofit(): Retrofit =
	Retrofit.Builder()
		.baseUrl(SERVER_URL)
		.addConverterFactory(GsonConverterFactory.create())
		.client(httpClient.build())
		.build()



