package com.example.androidUIPrac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androidUIPrac.databinding.ActivityMainBinding
import com.example.androidUIPrac.motionLayout.MotionLayoutPrac
import com.example.androidUIPrac.naverWebtoonClone.WebtoonFragment
import com.example.androidUIPrac.naverWebtoonClone.WebtoonMainFrag

//요일별  웹툰 리스트 및 기타 등등이 들어가는 fragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val list = arrayOf("네이버웹툰 ui","motionLayout 연습")
    val fragList = arrayOf(WebtoonMainFrag(), MotionLayoutPrac())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val adapter = ArrayAdapter(this, com.google.android.material.R.layout.mtrl_auto_complete_simple_item,list)
        binding.listview.adapter = adapter
        binding.listview.setOnItemClickListener { _, _, i, _ ->
            replaceFragment(fragList[i])
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentFrameLayout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commitAllowingStateLoss()
    }
}