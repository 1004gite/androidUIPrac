package com.example.androidUIPrac

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TestRecyclerAdapter: RecyclerView.Adapter<TestRecyclerAdapter.MVH>() {

    val item = Array<String>(100){it.toString()}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestRecyclerAdapter.MVH {
        return MVH(TextView(parent.context).apply {
            textSize = 15f
            textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        })
    }

    override fun onBindViewHolder(holder: MVH, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }

    class MVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(text: String){
            (itemView as TextView).text = text
        }
    }

}