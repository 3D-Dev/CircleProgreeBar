package com.example.circleprogresswithgradient

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.circleprogresswithgradient.R
import androidx.databinding.BindingAdapter
import com.example.circleprogresswithgradient.databinding.CircleViewBinding
import kotlinx.android.synthetic.main.circle_view.view.*

class TipViewCircle @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {
    private val binding: CircleViewBinding =
        CircleViewBinding.inflate(LayoutInflater.from(context), this, true)

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        binding.unbind()
    }

    fun changeToIcon() {
        binding.apply {
            progress.colors.add(ContextCompat.getColor(context, R.color.calorieCircleGradientColor1))
            progress.colors.add(ContextCompat.getColor(context, R.color.calorieCircleGradientColor2))
            progress.colors.add(ContextCompat.getColor(context, R.color.calorieCircleGradientColor3))
        }
    }

    fun setValue(text: String) {
        binding.text.text = text
    }

    fun setProgress(progress: Int) {
        binding.progress.progress = progress
    }
}

object TipViewCircleEx {
    @BindingAdapter("tip_view_value")
    @JvmStatic
    fun TipViewCircle.setValue(text: String) {
        setValue(text)
    }

    @BindingAdapter("tip_view_progress")
    @JvmStatic
    fun TipViewCircle.setProgress(progress: Int) {
        setProgress(progress)
    }

    @BindingAdapter("tip_view_percent")
    @JvmStatic
    fun TipViewCircle.setPercent(percentText: String) {
        setPercent(percentText)
    }
}