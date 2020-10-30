package ru.endroad.samples.screen.game.shared.render

import android.graphics.Bitmap

interface BoardTextures {

	val grampusBitmap: Bitmap
	val penguinBitmap: Bitmap

	fun resizeResources(height: Int, width: Int)
}