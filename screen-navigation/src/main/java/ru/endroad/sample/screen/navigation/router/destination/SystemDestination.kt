package ru.endroad.sample.screen.navigation.router.destination

import android.content.Intent

interface SystemDestination : Destination {

	fun createIntent(): Intent
}