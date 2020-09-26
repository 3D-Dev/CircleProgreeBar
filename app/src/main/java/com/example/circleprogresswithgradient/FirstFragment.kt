package com.example.circleprogresswithgradient
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.circleprogresswithgradient.databinding.FragmentFirstBinding
import com.wada811.databinding.dataBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val binding: FragmentFirstBinding by dataBinding(R.layout.fragment_first)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        initTipColor()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    private fun initTipColor() {
        binding.TipViewCircle.changeToIcon()
    }
}