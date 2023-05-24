package com.example.recyclerviewdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdemo.databinding.FragmentCourseCreatorBinding
import com.example.recyclerviewdemo.databinding.FragmentCourseSelectorBinding


class CourseCreatorFragment : Fragment() {

    private var _binding: FragmentCourseCreatorBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCourseCreatorBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val holes : MutableList<Hole> = mutableListOf(Hole(0,0),Hole(0,0),Hole(0,0),Hole(0,0),Hole(0,0),Hole(0,0),Hole(0,0),Hole(0,0),Hole(0,0))


        //Spinner
        val holesArrayAdapter = activity?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.Holes,
                android.R.layout.simple_spinner_item)
        }
        holesArrayAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = holesArrayAdapter
        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            var numOfHoles = 0
            override fun onItemSelected(
                adapterView: AdapterView<*>,
                childView: View?,
                position: Int,
                itemId: Long
            ) {
                numOfHoles = adapterView.getItemAtPosition(position).toString().toInt()

            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {  }
        }

        //Recycler View
        val myAdapter = HoleAdapter(holes)
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        return rootView
    }

}