package ru.endroad.samples.login.experiment

import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.java.KoinJavaComponent

inline fun <reified T : Any> Scene.inject(
	qualifier: Qualifier? = null,
	noinline parameters: ParametersDefinition? = null
) = lazy(LazyThreadSafetyMode.NONE) { KoinJavaComponent.get(T::class.java, qualifier, parameters) }