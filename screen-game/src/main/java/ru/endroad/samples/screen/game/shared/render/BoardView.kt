package ru.endroad.samples.screen.game.shared.render

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import ru.endroad.samples.screen.game.shared.animal.Grampus
import ru.endroad.samples.screen.game.shared.animal.Penguin
import ru.endroad.samples.screen.game.shared.board.*

class BoardView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null
) : View(context, attrs) {

	private val textures: BoardTextures = DefaultBoardTextures(resources)

	private var table: Field<Subject?> = emptyField(null)
	private var sizeX = 1
	private var sizeY = 1

	private var subjectHeight: Float = 0f
	private var subjectWidth: Float = 0f

	fun changeData(table: Field<Subject?>) {
		val subjects = mutableListOf<Subject>()
		table.forEachAll { it?.let(subjects::add) }

		this.table = table
		sizeX = table.size
		sizeY = table[0].size
		invalidate()
	}

	override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
		super.onSizeChanged(w, h, oldw, oldh)
		subjectHeight = height.toFloat() / sizeY
		subjectWidth = width.toFloat() / sizeX

		textures.resizeResources(subjectHeight.toInt(), subjectWidth.toInt())
	}

	override fun onDraw(canvas: Canvas?) {
		super.onDraw(canvas)
		canvas?.drawBackground()

		canvas?.drawSubjects()
	}

	private fun Canvas.drawBackground() {
		drawColor(Color.LTGRAY)
	}

	private fun Canvas.drawSubjects() {
		table.forEachIndexedAll { x, y, subject ->
			subject?.texture?.let {
				val xAxisOffset = subjectWidth * x
				val yAxisOffset = subjectHeight * y

				drawBitmap(it, xAxisOffset, yAxisOffset, null)
			}
		}
	}

	private val Subject.texture: Bitmap?
		get() = when (this) {
			is Grampus -> textures.grampusBitmap
			is Penguin -> textures.penguinBitmap
			else       -> null
		}
}