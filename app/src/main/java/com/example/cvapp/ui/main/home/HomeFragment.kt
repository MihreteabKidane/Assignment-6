package com.example.cvapp.ui.main.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.cvapp.R
import com.example.cvapp.domains.User
import com.example.cvapp.repository.ListDatasource

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)


        ListDatasource.save(
            User(
                1,
                "Brook",
                "Yemerou",
                "A passionate Java Developer playing a key role at all phases of the software development lifecycle. Hands-on expertise spanning Java, Spring, NodeJS, Express, jQuery, Angular, MySQL, MongoDB, and Python accompanied by machine learning and neural networks research. ",
                arrayListOf("Created Restful webservices", "Designing mobile app UIs"),
                arrayListOf(""),"",
                "",
                "https://www.linkedin.com/in/brookyemerou/",
                ""
            )
        )

        var user : User? = ListDatasource.find("1")
        view.findViewById<TextView>(R.id.id).text = user!!.userId.toString()
        view.findViewById<TextView>(R.id.username).text = "${user?.firstname} ${user?.lastname}"
        view.findViewById<TextView>(R.id.bio).text = user?.bio
        for(i in user!!.achievements) {
            val textView = TextView(requireContext())
            textView.text = "• $i"
            textView.setTextAppearance(R.style.TextStyle)
            val tableRow = TableRow(requireContext())
            tableRow.addView(textView, TableRow.LayoutParams.FILL_PARENT)
            view.findViewById<TableLayout>(R.id.table).addView(tableRow)
        }

        return view
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            fragmentManager!!.beginTransaction().detach(this).attach(this).commit()
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
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}