package com.example.cvapp.ui.main.about

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.cvapp.R
import com.example.cvapp.domains.User
import com.example.cvapp.repository.ListDatasource

const val ARG_PARAM1 = "param1"
class AboutMeFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_about_me, container, false)
        ListDatasource.save(
            User(
                1,
                "Brook",
                "Yemerou",
                "A passionate Java Developer playing a key role at all phases of the software " +
                        "development lifecycle. Hands-on expertise spanning Java, Spring, NodeJS, " +
                        "Express, jQuery, Angular, MySQL, MongoDB, and Python accompanied by machine " +
                        "learning and neural networks research. ",
                arrayListOf("Created Restful webservices", "Designing mobile app UIs"),
                "",
                "https://www.linkedin.com/in/brookyemerou/",
                "",
                ""
            )
        )
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
            AboutMeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }




    }


