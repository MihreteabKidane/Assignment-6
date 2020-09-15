package com.example.cvapp.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.cvapp.ui.main.home.HomeFragment
import com.example.cvapp.ui.main.work.WorkFragment
import com.example.cvapp.ui.main.contact.ContactFragment
/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return when(position) {
            0 -> HomeFragment.newInstance("Home", "param2")
            1 -> HomeFragment.newInstance("About", "param2")
            2 -> WorkFragment.newInstance("Work", "param2")
            3 -> ContactFragment.newInstance("Contact", "param2")
            else -> HomeFragment.newInstance("Home", "param2")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Home"
            1 -> "About"
            2 -> "Work"
            3 -> "Contact"
            else -> "Home"
        }
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 4
    }
}