package ru.endroad.samples.login.router.navigator

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.endroad.component.core.*
import ru.endroad.samples.login.application.NavigationViewModel
import ru.endroad.samples.login.error.DomainError
import ru.endroad.samples.login.experiment.Scene
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface Navigator {

	var hubActivity: AppCompatActivity?
	var navigationViewModel: NavigationViewModel?

	fun changeRoot(screen: Scene) {
		navigationViewModel?.currentScreen?.tryEmit(screen)
	}


	fun openNoticeAlertDialog(message: String) {
		hubActivity?.let(AlertDialog::Builder)?.apply {
			setMessage(message)
			setCancelable(true)
			setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
		}
			?.create()
			?.show()
	}

	suspend fun openSignDialog(socialNetworkName: String, message: String): Unit =
		suspendCoroutine { continuation ->
			hubActivity?.let(AlertDialog::Builder)?.apply {
				setTitle(socialNetworkName)
				setMessage(message)
				setCancelable(true)
				setPositiveButton("Успешно") { dialog, _ ->
					dialog.dismiss()
					continuation.resume(Unit)
				}
				setNegativeButton("Неуспешно") { dialog, _ ->
					dialog.dismiss()
					continuation.resumeWithException(DomainError.Unauthorized("Ошибка авторизации"))
				}
			}
				?.create()
				?.show()
		}
}