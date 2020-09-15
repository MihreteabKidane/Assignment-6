package com.example.cvapp.domains

data class User(var userId : Int, var firstname : String, var lastname : String, var bio : String, var achievements : ArrayList<String>, var facebook : String, var twitter : String, var linkedIn : String, var personal : String) {
}