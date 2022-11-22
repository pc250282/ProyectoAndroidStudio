package com.example.proyectologin

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


//Accedemos a todos los elementos de la vista
fun View.esconderTeclado(){
    val input=this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    input.hideSoftInputFromWindow(windowToken, 0)
}