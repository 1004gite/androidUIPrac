package com.example.androidUIPrac

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.androidUIPrac.coordinatorLayout.CoordinatorPracFragment
import com.example.androidUIPrac.databinding.ActivityMainBinding
import com.example.androidUIPrac.motionLayout.MotionLayoutPrac
import com.example.androidUIPrac.naverWebtoonClone.WebtoonMainFrag

//요일별  웹툰 리스트 및 기타 등등이 들어가는 fragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.recyclerView.adapter = MyAdap()
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL))
        binding.recyclerView.setBackgroundColor(Color.LTGRAY)
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.baseLayout, fragment)
//        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commitAllowingStateLoss()
    }

    inner class MyAdap: RecyclerView.Adapter<MyAdap.Myvh>(){

        val list = arrayOf("네이버웹툰 ui","coordinator","motionLayout 연습")
        val fragList = arrayOf(WebtoonMainFrag(), CoordinatorPracFragment(), MotionLayoutPrac())

        inner class Myvh(itemView: View) : RecyclerView.ViewHolder(itemView){
            fun bind(text: String, frag: Fragment){
                (itemView as TextView).text = text
                itemView.setOnClickListener { replaceFragment(frag) }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myvh {
            return Myvh(TextView(parent.context).apply {
                textSize = 20f
                setTextColor(Color.BLACK)
                setPadding(10)
            })
        }

        override fun onBindViewHolder(holder: Myvh, position: Int) {
            holder.bind(list[position], fragList[position])
        }

        override fun getItemCount(): Int {
            return list.size
        }
    }
}