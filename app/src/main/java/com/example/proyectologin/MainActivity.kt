package com.example.proyectologin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.proyectologin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnLogin.setOnClickListener {

            validaciones()
       }

        binding.btnRegistrarse.setOnClickListener {
            it.esconderTeclado()
            var intent = Intent(this, registro_datos::class.java)
            startActivity(intent)
        }



    }

    fun setData() {

        var convertStringUser = binding.txtUser.text.toString()
        var convertStringPass = binding.txtPass.text.toString()
        val user1 = Users(convertStringUser, convertStringPass)
        var intent = Intent(this, menu_usuario::class.java)
        intent.putExtra("mostrar", user1)
        startActivity(intent)

    }

    fun validaciones(){

        if(binding.txtUser.text.isEmpty()||binding.txtPass.text.isEmpty()){
            Toast.makeText(this,"Completa ambos datos para ingresar",Toast.LENGTH_SHORT).show()
        }else   {
            setData()
        }
    }

}


