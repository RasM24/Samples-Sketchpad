package sample.endroad.coroutines.application

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sample.endroad.coroutines.coroutine.CoroutineViewModel
import sample.endroad.coroutines.flow.FlowViewModel
import sample.endroad.coroutines.reality.RealityViewModel

val viewModelModule = module {

	viewModel { CoroutineViewModel() }
	viewModel { FlowViewModel() }
	viewModel { RealityViewModel(get(), get()) }
}