package com.example.proyectologin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)



        val obj1=intent.getParcelableExtra<Users>("a")
        val txtWelcome=findViewById<TextView>(R.id.txtWelcome)
        val btnRegistrar=findViewById<Button>(R.id.btnRegistrar)
        if(obj1!=null){
        val nombre=obj1.nameUser
            txtWelcome.setText(nombre)
            }
        //Declaro varible

        //Seteo el texto con valor de la variable user.

        btnRegistrar.setOnClickListener {
            var intent= Intent(this,RegistroDatos::class.java)
            startActivity(intent)
        }



    }



}


