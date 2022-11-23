package com.example.proyectologin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class menu_usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)



        val obj1=intent.getParcelableExtra<Usuario>("mostrar")
        val txtWelcome=findViewById<TextView>(R.id.txtWelcome)
        val btnVerDatos=findViewById<Button>(R.id.btnVerMisDatos)
        if(obj1!=null){
        val nombre=obj1.nombre
            txtWelcome.setText(obj1.nombre)
            }
        //Declaro varible

        //Seteo el texto con valor de la variable user.


        btnVerDatos.setOnClickListener {
            val intent = Intent(this, mostrar_datos_persona::class.java)
            intent.putExtra("usuario",obj1)
            startActivity(intent)
        }


    }



}


