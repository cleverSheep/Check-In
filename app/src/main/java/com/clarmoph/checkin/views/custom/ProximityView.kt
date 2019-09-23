package com.clarmoph.checkin.views.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color.parseColor
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View


class ProximityView(context: Context?, attrs: AttributeSet) : View(context, attrs) {


    companion object {
        private val DEFAULT_FILL_COLOR = parseColor("#808FAC")
        private const val DEFAULT_RADIUS_SIZE = 150.0f
    }

    private var fillColor = DEFAULT_FILL_COLOR
    private var radiusSize = DEFAULT_RADIUS_SIZE


    private val paint = Paint()
    private var size = 0

    private var radius = radiusSize
        set(rSize) {
            field = rSize
            invalidate()
        }

    init {
        paint.isAntiAlias = true
        setupAttributes(attrs)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawProximity(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val desiredWidth = suggestedMinimumWidth + paddingLeft + paddingRight
        val desiredHeight = suggestedMinimumHeight + paddingTop + paddingBottom

        setMeasuredDimension(
            measureDimension(desiredWidth, widthMeasureSpec),
            measureDimension(desiredHeight, heightMeasureSpec)
        )
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray =
            context.theme.obtainStyledAttributes(
                attrs,
                com.clarmoph.checkin.R.styleable.ProximityView,
                0,
                0
            )

        fillColor = typedArray.getColor(
            com.clarmoph.checkin.R.styleable.ProximityView_fillColor,
            DEFAULT_FILL_COLOR
        )
        radiusSize =
            typedArray.getDimension(
                com.clarmoph.checkin.R.styleable.ProximityView_radiusSize,
                DEFAULT_RADIUS_SIZE
            )

        typedArray.recycle()
    }

    private fun drawProximity(canvas: Canvas?) {
        paint.color = DEFAULT_FILL_COLOR
        paint.style = Paint.Style.FILL
        paint.alpha = 120

        canvas?.drawCircle(
            size / 2f,
            size / 2f, radius, paint
        )

    }

    private fun measureDimension(desiredSize: Int, measureSpec: Int): Int {
        var result: Int
        val specMode = View.MeasureSpec.getMode(measureSpec)
        val specSize = View.MeasureSpec.getSize(measureSpec)

        if (specMode == View.MeasureSpec.EXACTLY) {
            result = specSize
        } else {
            result = desiredSize
            if (specMode == View.MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize)
            }
        }

        if (result < desiredSize) {
            Log.e("ChartView", "The view is too small, the content might get cut")
        }
        return result
    }


}