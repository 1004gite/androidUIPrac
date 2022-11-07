package com.example.androidUIPrac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androidUIPrac.databinding.ActivityMainBinding

//요일별  웹툰 리스트 및 기타 등등이 들어가는 fragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        replaceFragment(WebtoonFragment().apply { arguments?.putInt("bottomNavHeight", this@MainActivity.binding.bottomNavBar.height) })
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentFrameLayout, fragment)
        fragmentTransaction.commit()
    }
}