package com.example.androidUIPrac.naverWebtoonClone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidUIPrac.R
import com.example.androidUIPrac.databinding.WebtoonListFragmentBinding


class ListFragment : Fragment() {

    lateinit var binding: WebtoonListFragmentBinding
    var dontMove = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.webtoon_list_fragment, container, false)
        arguments?.let {
//            binding.testView.setBackgroundColor(it.getInt("Color"))
        }
        binding.recyclerView.adapter = myAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

//        binding.recyclerView.setOnTouchListener { view, motionEvent ->
//            // 특정 조건일 때 true로 touch event가 안먹히게 하자
//            dontMove
//        }

        return binding.root
    }


    class myAdapter: RecyclerView.Adapter<myAdapter.viewHolder>(){

        val item = IntArray(10)

        inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
            val binding = LayoutInflater.from(parent.context).inflate(R.layout.webtoon_list_item,null)
            return viewHolder(binding.rootView)
        }

        override fun onBindViewHolder(holder: viewHolder, position: Int) {
        }

        override fun getItemCount(): Int {
            return item.size
        }

    }

}