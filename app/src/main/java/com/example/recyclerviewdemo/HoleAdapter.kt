package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.databinding.ListItemLayoutCourseBinding
import com.example.recyclerviewdemo.databinding.ListItemLayoutCreateCourseBinding

class HoleAdapter(val HoleList: List<Hole>) : RecyclerView.Adapter<HoleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoleViewHolder {
        val binding = ListItemLayoutCreateCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HoleViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HoleViewHolder, position: Int) {
        val currentHole = HoleList[position]
        holder.bindRound(currentHole, position+1)
    }

    override fun getItemCount(): Int {
        return HoleList.size
    }

    fun getHoles(holder: HoleViewHolder) : List<Hole> {
        return holder.getHoles()
    }
}