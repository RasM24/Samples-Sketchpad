package sample.endroad.coroutines.application

import android.widget.TextView

fun TextView.appendText(message: String) {
	val log = "$text\n$message"
	text = log
}