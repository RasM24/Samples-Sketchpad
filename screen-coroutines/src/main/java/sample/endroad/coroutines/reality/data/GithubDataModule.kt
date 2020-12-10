package sample.endroad.coroutines.reality.data

import org.koin.dsl.module
import org.koin.experimental.builder.single
import retrofit2.Retrofit
import retrofit2.create

val githubDataModule = module {
	single { buildRetrofit() }

	single { get<Retrofit>().create<GithubApi>() }

	single<GithubDataSource>()
}