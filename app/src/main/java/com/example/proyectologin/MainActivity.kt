package com.example.proyectologin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegistrarse = findViewById<Button>(R.id.btnRegistrarse)
        val txtUser = findViewById<EditText>(R.id.txtUser)
        val txtPass = findViewById<EditText>(R.id.txtPass)


        btnLogin.setOnClickListener {

            validaciones()
       }

        btnRegistrarse.setOnClickListener {
            it.esconderTeclado()
            var intent = Intent(this, RegistroDatos::class.java)
            startActivity(intent)
        }



    }

    fun setData() {
        val txtUser = findViewById<EditText>(R.id.txtUser)
        val txtPass = findViewById<EditText>(R.id.txtPass)
        var convertStringUser = txtUser.text.toString()
        var convertStringPass = txtPass.text.toString()
        val user1 = Users(convertStringUser, convertStringPass)
        var intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("mostrar", user1)
        startActivity(intent)

    }

    fun validaciones(){
        val txtUser = findViewById<EditText>(R.id.txtUser)
        val txtPass = findViewById<EditText>(R.id.txtPass)
        if(txtUser.text.isEmpty()||txtPass.text.isEmpty()){
            Toast.makeText(this,"Completa ambos datos para ingresar",Toast.LENGTH_SHORT).show()
        }else   {
            setData()
        }
    }

}


