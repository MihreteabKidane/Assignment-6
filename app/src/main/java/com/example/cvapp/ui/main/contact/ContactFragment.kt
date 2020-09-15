package com.example.cvapp.ui.main.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.cvapp.R
import com.example.cvapp.ui.main.work.WorkFragment

/**
 * A simple [Fragment] subclass.
 */

private const val ARG_PARAM1 = "param1"
class ContactFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_contact, container, false)
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
                ContactFragment().apply {
                    arguments = Bundle().apply {
                        putString(com.example.cvapp.ui.main.contact.ARG_PARAM1, param1)
                    }
                }
    }

}