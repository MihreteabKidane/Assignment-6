package com.example.cvapp.ui.main.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ContactViewModel : ViewModel() {

    private val _contact = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_contact) {
        "Hello world from section: $it"
    }

    fun setIndex(index: Int) {
        _contact.value = index
    }
}
