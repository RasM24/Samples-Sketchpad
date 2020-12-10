package sample.endroad.coroutines.reality.data

import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.experimental.builder.single
import retrofit2.Retrofit
import retrofit2.create

val guruQualifier = named("GuruServer")
val githubQualifier = named("GithubServer")

val dataModule = module {
	single(guruQualifier) { buildGuruRetrofit() }
	single(githubQualifier) { buildGithubRetrofit() }

	single { get<Retrofit>(guruQualifier).create<GuruApi>() }
	single { get<Retrofit>(githubQualifier).create<GithubApi>() }

	single<GuruDataSource>()
	single<GithubDataSource>()
}