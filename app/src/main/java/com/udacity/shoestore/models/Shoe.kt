package com.udacity.shoestore.models

import android.text.Editable

data class Shoe(var name: String, var size: Double, var company: String, var description: String) {


    fun setName(editable: Editable) {
        name = editable.toString()
    }

    fun setCompany(editable: Editable) {
        company = editable.toString()
    }

//    fun setSize(editable: Editable) {
//        editable.toString().toDoubleOrNull()?.let { size = it }
//    }

    fun setDescription(editable: Editable) {
        description = editable.toString()
    }


}

