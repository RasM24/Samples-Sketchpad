package ru.endroad.samples.screen.listing.router.navigator

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.endroad.navigation.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface Navigator {
	val container: Int
	var hubActivity: AppCompatActivity?

	fun open(fragment: Fragment) {
		hubActivity?.supportFragmentManager?.forwardTo(fragment, defaultForwardAnimation, container)
	}

	fun replace(fragment: Fragment) {
		hubActivity?.supportFragmentManager?.replace(fragment, defaultReplaceAnimation, container)
	}

	fun changeRoot(fragment: Fragment) {
		hubActivity?.supportFragmentManager?.changeRoot(fragment, defaultReplaceAnimation, container)
	}

	fun back() {
		hubActivity?.supportFragmentManager?.back()
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
}