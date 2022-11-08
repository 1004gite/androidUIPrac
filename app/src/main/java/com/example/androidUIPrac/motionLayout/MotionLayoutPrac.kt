package com.example.androidUIPrac.motionLayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androidUIPrac.R
import com.example.androidUIPrac.databinding.MotionlayoutPracFragmentBinding

class MotionLayoutPrac: Fragment() {

    lateinit var binding: MotionlayoutPracFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.motionlayout_prac_fragment,container, false)
        return binding.root
    }
}