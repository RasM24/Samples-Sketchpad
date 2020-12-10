package sample.endroad.coroutines.reality.data

class GuruDataSource(
	private val api: GuruApi,
) {

	suspend fun browseSeries() =
		api.browseSeries()
}