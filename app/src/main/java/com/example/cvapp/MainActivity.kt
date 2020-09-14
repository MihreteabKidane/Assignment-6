package com.example.cvapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.cvapp.repository.ListDatasource
import com.example.cvapp.repository.ListDatasource.editBio
import com.example.cvapp.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }

    fun click(view: View) {
        var builder = AlertDialog.Builder(view.context)
        when(view.id) {
            R.id.editBio -> editText(builder, view)
            R.id.achieve -> addAchievement(builder, view)
        }
        builder.create().show()
    }

    fun editText(builder: AlertDialog.Builder, view : View) {
        builder.setTitle("Edit")
        val editText = EditText(view.context)
        editText.setText(ListDatasource.find("1")!!.bio)
        builder.setView(editText)
        builder.setPositiveButton("Save") { dialogInterface, which ->
            run {
                ListDatasource.editBio("1", editText.text.toString())
                bio.text = ListDatasource.find("1")!!.bio
                reload()
                dialogInterface.dismiss()
            }
        }
        builder.setNegativeButton("Cancel") { dialog, which -> dialog.dismiss() }
    }


    private fun addAchievement(builder : AlertDialog.Builder, view : View) {
        builder.setTitle("Add Achievement")
        val editText = EditText(view.context)
        builder.setView(editText)
        builder.setPositiveButton("Add") { dialogInterface, which ->
            run {
                ListDatasource.addAchievement("1", editText.text.toString())
                dialogInterface.dismiss()
            }
        }
        builder.setNegativeButton("Cancel") { dialog, which -> dialog.dismiss() }
    }


    fun reload() {
        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        val tab = tabLayout.getTabAt(1)
        tab!!.select()
    }
}