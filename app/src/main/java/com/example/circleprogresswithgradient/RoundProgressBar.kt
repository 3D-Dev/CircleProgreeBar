package com.example.circleprogresswithgradient

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import com.example.circleprogresswithgradient.R

class RoundProgressBar : ProgressBar {

    var innerRadiusRatio = 2.28f
    var thicknessRatio = 34.22f
    var startAngle = 270f
    var colors = ArrayList<Int>()

    private var mBoundsF: RectF? = null
    private lateinit var mPaint: Paint
    private lateinit var mBackgroundPaint: Paint

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        mPaint = Paint()
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeCap = Paint.Cap.ROUND

        mBackgroundPaint = Paint()
        mBackgroundPaint.isAntiAlias = true
        mBackgroundPaint.style = Paint.Style.STROKE
        mBackgroundPaint.color = ContextCompat.getColor(context, R.color.circleBackground)

        progressDrawable = null
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        if (mBoundsF == null) {
            val w = width.toFloat()
            val thickness = w / thicknessRatio
            mPaint.strokeWidth = thickness
            mBackgroundPaint.strokeWidth = thickness

            mBoundsF = RectF( left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat())
            val delta = (w - (w * 2 / innerRadiusRatio)) / 2 - thickness / 2
            mBoundsF?.inset(delta, delta)
        }

        canvas?.drawArc(mBoundsF!!, startAngle, 360f, false, mBackgroundPaint)
        if (colors.size > 0) {
            val linGrad = LinearGradient(
                height.toFloat() / 2,
                0f,
                height.toFloat() / 2,
                width.toFloat(),
                colors.toIntArray(),
                when (colors.size) {
                    2 -> floatArrayOf(0f, 1f)
                    3 -> floatArrayOf(0f, 0.5f, 1f)
                    else -> floatArrayOf(1f)
                },
                Shader.TileMode.CLAMP
            )
            mPaint.shader = linGrad
            canvas?.drawArc(mBoundsF!!, startAngle, progress * 3.60f, false, mPaint)
        }
    }
}
