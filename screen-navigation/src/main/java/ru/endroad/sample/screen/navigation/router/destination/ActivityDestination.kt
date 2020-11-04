package ru.endroad.sample.screen.navigation.router.destination

import android.content.Intent

interface ActivityDestination : Destination {

	fun createIntent(): Intent
}