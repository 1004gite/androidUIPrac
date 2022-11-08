package com.example.androidUIPrac.coordinatorLayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androidUIPrac.R
import com.example.androidUIPrac.TestRecyclerAdapter
import com.example.androidUIPrac.databinding.CoordinatorlayoutPracFragmentBinding

class CoordinatorPracFragment: Fragment() {

    lateinit var binding: CoordinatorlayoutPracFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.coordinatorlayout_prac_fragment, container, false)
        binding.coordinatorPracRcyclerView.adapter = TestRecyclerAdapter()
//        (activity as AppCompatActivity).apply {
//            setSupportActionBar(binding.coordToolbar)
//            supportActionBar?.setDisplayShowTitleEnabled(true)
//            supportActionBar?.title = "this is title"
//        }

        return binding.root
    }
}