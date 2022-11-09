package com.example.androidUIPrac.motionLayout

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androidUIPrac.R
import com.example.androidUIPrac.TestRecyclerAdapter
import com.example.androidUIPrac.databinding.Motionlayout2FragmentBinding

class MotionLayout2: Fragment() {

    lateinit var binding: Motionlayout2FragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.motionlayout_2_fragment, container, false)
        binding.recyclerView.adapter = TestRecyclerAdapter()

        binding.textView.setOnClickListener {
            binding.appBar.setExpanded(true)
        }

        return binding.root
    }
}