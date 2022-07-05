package com.example.proyectologin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        //capturamos informacion extra que nos llega
        val bundle=intent.extras
        //obtengo el dato especifico
        val user=bundle?.getString("user")
        //Declaro varible
        val txtWelcome=findViewById<TextView>(R.id.txtWelcome)
        val imgWelcome=findViewById<ImageView>(R.id.imgWelcome)
        //Seteo el texto con valor de la variable user.
        txtWelcome.setText("Bienvenido: "+user)


    }



}


