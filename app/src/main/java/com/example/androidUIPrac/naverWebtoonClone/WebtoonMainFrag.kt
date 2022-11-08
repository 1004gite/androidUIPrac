package com.example.androidUIPrac.naverWebtoonClone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androidUIPrac.R
import com.example.androidUIPrac.databinding.WebtoonMainFragmentBinding

class WebtoonMainFrag: Fragment() {

    lateinit var binding: WebtoonMainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.webtoon_main_fragment,container,false)
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentFrameLayout,
            WebtoonFragment().apply { arguments?.putInt("bottomNavHeight", this@WebtoonMainFrag.binding.bottomNavBar.height )})
            ?.commitAllowingStateLoss()

        return binding.root
    }
}