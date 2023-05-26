package com.example.recyclerviewdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.databinding.FragmentCourseCreatorBinding
import com.example.recyclerviewdemo.databinding.FragmentCourseSelectorBinding
import com.example.recyclerviewdemo.databinding.ListItemLayoutCreateCourseBinding

val courseHoles = mutableListOf<Hole>()
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
        val myAdapter = HoleAdapter(holes.toList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = myAdapter

        binding.setCourseButton.setOnClickListener() {


            val course = Course(binding.editTextTextPersonName2.text.toString(), courseHoles, 9, 36)



            setFragmentResult("requestKey", bundleOf("bundleKey" to course))
            rootView.findNavController().navigateUp()

        }

        return rootView
    }

}

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
}

class HoleViewHolder(val binding: ListItemLayoutCreateCourseBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var currentHole: Hole


    fun bindRound(Hole: Hole, num : Int) {
        currentHole = Hole
        binding.HoleNumber.text = num.toString()
        currentHole.par = if (binding.parFiveButton.isChecked) 5 else if(binding.parFourButton.isChecked) 4 else 3
        courseHoles.add(currentHole)
    }
}
