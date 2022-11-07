package com.example.androidUIPrac

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidUIPrac.databinding.FragmentWebtoonBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator

class WebtoonFragment : Fragment() {

    lateinit var binding: FragmentWebtoonBinding
    val tabTexts = arrayListOf<String>("신작", "월", "화", "수", "목", "금", "토", "일", "매일+", "완결")
    val frags = Array(tabTexts.size){ListFragment()}

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var bottomNavHeight: Int = arguments?.getInt("bottomNavHeight") ?: 150
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_webtoon, container, false)
        binding.viewPager.adapter = MyPagerAdapter(requireContext() as FragmentActivity)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTexts[position]
        }.attach()

        val mHeight = binding.root.resources.displayMetrics.heightPixels - bottomNavHeight
        val heightTop = 400
        val heightTabLayout = 150
        val heightFragment = mHeight - heightTop
        binding.adRecycler.also {
            it.layoutParams =
                AppBarLayout.LayoutParams(AppBarLayout.LayoutParams.MATCH_PARENT, heightTop)
//                    .apply { setMargins(0,0,0,heightTabLayout) }
//                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, heightTop)
            it.adapter = AdRecyclerAdapter()
            val snapHelper = LinearSnapHelper().apply { attachToRecyclerView(it) }
            it.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                var pos = RecyclerView.NO_POSITION
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (recyclerView.layoutManager != null) {
                        val view = snapHelper.findSnapView(recyclerView.layoutManager)!!
                        val position = recyclerView.layoutManager!!.getPosition(view)

                        if (pos != position) {
                            pos = position
                            it.scrollToPosition(pos)
                        }
                    }
                }
            })
        }
        binding.tabLayout.layoutParams =
//            CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.WRAP_CONTENT, heightTabLayout)
            FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, heightTabLayout)

//        binding.viewPager.layoutParams =
////            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, heightFragment)
//            CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT, heightFragment)
//        binding.testRecycler.adapter = testRecyclerAdapter()
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)


//        Log.e(
//            "test",
//            "heightTop= $heightTop, heightTab = $heightTabLayout, heightFrag = $heightFragment, bottomNav = ${bottomNavHeight}, total = $mHeight"
//        )

        return binding.root
    }


    inner class MyPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        private val NUM_PAGES = 10
        private val colors = arrayListOf<Int>(Color.BLUE, Color.YELLOW, Color.CYAN)

        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment {
            return frags[position]
        }
    }

    class AdRecyclerAdapter : RecyclerView.Adapter<AdRecyclerAdapter.AdRecyclerViewHolder>() {

        val item = intArrayOf(Color.CYAN, Color.YELLOW, Color.BLACK, Color.DKGRAY, Color.RED)

        class AdRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun setColor(color: Int) {
                itemView.setBackgroundColor(color)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdRecyclerViewHolder {
            val testView = TextView(parent.context).apply {
                layoutParams = CoordinatorLayout.LayoutParams(1000,CoordinatorLayout.LayoutParams.MATCH_PARENT)
            }
            return AdRecyclerViewHolder(testView)
        }

        override fun onBindViewHolder(holder: AdRecyclerViewHolder, position: Int) {
            holder.setColor(item[position])
        }

        override fun getItemCount(): Int {
            return item.size
        }


    }

//    class testRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//        val list = mutableListOf<Int>().apply { repeat(100){add(it)} }
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): testRecyclerViewHolder {
//            val testView = TextView(parent.context).apply {
//                layoutParams = CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT,50)
//            }
//            return testRecyclerViewHolder(testView)
//        }
//
//        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//            (holder as testRecyclerViewHolder).bind(list[position])
//        }
//
//        override fun getItemCount(): Int {
//            return list.size
//        }
//
//        class testRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            fun bind(num: Int) {
//                (itemView as TextView).text = num.toString()
//            }
//        }
//    }
}