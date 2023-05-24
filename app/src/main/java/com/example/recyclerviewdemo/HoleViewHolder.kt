package com.example.recyclerviewdemo
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.databinding.ListItemLayoutCreateCourseBinding

class HoleViewHolder(val binding: ListItemLayoutCreateCourseBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var currentHole: Hole
    private val Holes = mutableListOf<Hole>()


    fun bindRound(Hole: Hole, holeNum : Int) {
        currentHole = Hole
        binding.HoleNumber.text = holeNum.toString()
        currentHole.par = if (binding.parFiveButton.isChecked) 5 else if(binding.parFourButton.isChecked) 4 else 3
        currentHole.distance = binding.YardageEdittext.text.toString().toInt()
        Holes.add(currentHole)


    }
    fun getHoles() : List<Hole> {
        Holes.toList()
        return Holes
    }
}