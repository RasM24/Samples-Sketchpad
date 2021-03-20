package ru.endroad.component.core

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn

abstract class MviFragment<STATE, EVENT> : CampFragment() {

	abstract val viewModel: MviViewModel<STATE, EVENT>

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel.state
			.onEach { render(it) }
			.launchIn(lifecycleScope)
	}

	protected abstract fun render(state: STATE)
}