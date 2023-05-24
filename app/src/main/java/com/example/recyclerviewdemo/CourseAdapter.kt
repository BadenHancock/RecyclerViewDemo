package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.databinding.ListItemLayoutCourseBinding

class CourseAdapter(val CourseList: List<Course>) : RecyclerView.Adapter<CourseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ListItemLayoutCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val currentCourse = CourseList[position]
        holder.bindRound(currentCourse)
    }

    override fun getItemCount(): Int {
        return CourseList.size
    }
}