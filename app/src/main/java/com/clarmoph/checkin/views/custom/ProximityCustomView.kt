package com.clarmoph.checkin.views.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.clarmoph.checkin.R
import kotlin.math.min

class ProximityCustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    companion object {
        private const val DEFAULT_FILL_COLOR = Color.BLUE
        private const val DEFAULT_RADIUS_SIZE = 25f
        private const val RADIUS_MULTIPLIER = 1.5F
    }

    private val mPaint: Paint = Paint()
    private var fillColor =
        DEFAULT_FILL_COLOR

    init {
        setUpAttributes(attrs)
        mPaint.apply {
            isAntiAlias = true
            color = fillColor
            style = Paint.Style.FILL
        }
    }

    var radiusSize =
        DEFAULT_RADIUS_SIZE
        set(size) {
            field = size * RADIUS_MULTIPLIER
            postInvalidate()
        }

    override fun onDraw(canvas: Canvas?) {
        drawProximity(canvas)
    }

    private fun drawProximity(canvas: Canvas?) {
        canvas?.drawCircle(width / 2f, height / 2f, radiusSize, mPaint)

    }

    private fun setUpAttributes(attrs: AttributeSet?) {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.ProximityCustomView, 0, 0)
        fillColor = typedArray.getColor(R.styleable.ProximityCustomView_fillColor, fillColor)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.v("ProximityCustomView", MeasureSpec.toString(widthMeasureSpec));
        Log.v("ProximityCustomView", MeasureSpec.toString(heightMeasureSpec));

        val desiredWidth = suggestedMinimumWidth + paddingLeft + paddingRight
        val desiredHeight = suggestedMinimumHeight + paddingTop + paddingBottom

        setMeasuredDimension(
            measureDimension(desiredWidth, widthMeasureSpec),
            measureDimension(desiredHeight, heightMeasureSpec)
        )
    }

    private fun measureDimension(desiredSize: Int, measureSpec: Int): Int {
        var result: Int

        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)

        when (specMode) {
            MeasureSpec.EXACTLY -> result = specSize
            else -> {
                result = desiredSize
                if (specMode == MeasureSpec.AT_MOST) result = min(result, specSize)
            }
        }

        if (result < desiredSize) {
            Log.d("ProximityCustomView", "The view is too small, the content might get cut")
        }
        return result
    }

}