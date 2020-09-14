package com.example.cvapp.ui.main.work

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.example.cvapp.R
import com.example.cvapp.domains.Work
import com.sng.homework6.ui.work.WorkRecyclerViewAdapter
import com.sng.homework6.ui.work.WorkViewModel
import kotlinx.android.synthetic.main.fragment_work.*

private const val ARG_PARAM1 = "param1"

class WorkFragment : Fragment() {
    lateinit var fmanager: FragmentManager
    lateinit var tx: FragmentTransaction

    private lateinit var workViewModel: WorkViewModel

    var workList = ArrayList<Work>()
    var layoutManager: RecyclerView.LayoutManager? = null
    var madr: WorkRecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fmanager = getActivity()?.getSupportFragmentManager()!!


        val spf = context?.getSharedPreferences("workFile", Context.MODE_PRIVATE)
        // if list exists, convert shared preferences list to kotlin list
        try {
            val workListString = spf?.getString("workList", "something went wrong!")
            var works = Gson().fromJson(workListString, Array<Work>::class.java).toMutableList()
            for (work in works) {
                workList.add(work)
            }
        } catch (exception: Exception) {
            Toast.makeText(
                context, "No work is added yet",
                Toast.LENGTH_SHORT
            ).show()
        }

        workViewModel =
            ViewModelProviders.of(this).get(WorkViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_work, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //configure recycler view
        madr = WorkRecyclerViewAdapter(context, workList)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = madr

        fab.setOnClickListener { view ->
            val intent = Intent(context, AddWorkActivity::class.java)
            startActivity(intent)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WorkFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}