package com.example.proyectologin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.proyectologin.databinding.ActivitySegundaBinding
import com.example.proyectologin.databinding.ActivityUtilidadBuscaRazaBinding

class menu_usuario : AppCompatActivity() {
    private lateinit var binding: ActivitySegundaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val obj1=intent.getParcelableExtra<Usuario>("mostrar")


        if(obj1!=null){
        val nombre=obj1.nombre
            binding.txtWelcome.setText("Bienvenido: "+ obj1.nombre)
            }
        //Declaro varible

        //Seteo el texto con valor de la variable user.


        /*binding.btnVerMisDatos.setOnClickListener {
            val intent = Intent(this, mostrar_datos_persona::class.java)
            intent.putExtra("usuario",obj1)
            startActivity(intent)
        }*/

        binding.btnUtilidad.setOnClickListener {
            val siguiente=Intent(this, utilidad_busca_raza::class.java)
            startActivity(siguiente)
        }



    }



}


