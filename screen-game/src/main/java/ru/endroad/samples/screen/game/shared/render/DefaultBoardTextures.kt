package ru.endroad.samples.screen.game.shared.render

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import ru.endroad.samples.screen.game.R

class DefaultBoardTextures(resources: Resources) : BoardTextures {

	private val originalGrampusBitmap = BitmapFactory.decodeResource(resources, R.drawable.grampus)
	private val originalPenguinBitmap = BitmapFactory.decodeResource(resources, R.drawable.penguin)

	override var grampusBitmap: Bitmap = originalGrampusBitmap
	override var penguinBitmap: Bitmap = originalPenguinBitmap

	override fun resizeResources(height: Int, width: Int) {
		grampusBitmap = originalGrampusBitmap.scaleTo(height, width)
		penguinBitmap = originalPenguinBitmap.scaleTo(height, width)
	}

	private fun Bitmap.scaleTo(height: Int, width: Int): Bitmap =
		Bitmap.createScaledBitmap(this, width, height, false)
}