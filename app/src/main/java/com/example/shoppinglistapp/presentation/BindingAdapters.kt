package com.example.shoppinglistapp.presentation

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("tilNameError")
fun bindTilNameError(til: TextInputLayout, isError: Boolean) {
    val message = if (isError) {
        "Проверьте, что ввели название"
    } else {
        null
    }
    til.error = message
}

@BindingAdapter("tilCountError")
fun bindTilCountError(til: TextInputLayout, isError: Boolean) {
    val message = if (isError) {
        "Проверьте, что указали число"
    } else {
        null
    }
    til.error = message
}