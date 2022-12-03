package com.example.proyectologin

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible
import com.example.proyectologin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val usuarioLogin=Usuario("1234")
        usuarioLogin.mail="pabloacalvo@live.com"
        usuarioLogin.nombre="Pablo"
        usuarioLogin.apellido="Calvo"
        usuarioLogin.direccion="Manuel castro"
        usuarioLogin.documento="35994686"

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnLogin.setOnClickListener {
            validacionesUsuarioExistente()
       }

        binding.btnRegistrarse.setOnClickListener {
            it.esconderTeclado()
            var intent = Intent(this, registro_datos::class.java)
            startActivity(intent)
        }

        binding.btnInfo.setOnClickListener{
            mostrarInfoApp()
        }
        
    }

    fun setData() {

        var convertStringUser = binding.txtUser.text.toString()
        var convertStringPass = binding.txtPass.text.toString()
        val user1 = Users(convertStringUser, convertStringPass)
        val siguiente=Intent(this, utilidad_busca_raza::class.java)
        //siguiente.putExtra("mostrar", user1)
        startActivity(siguiente)

    }

    fun validacionesUsuarioExistente(){

        if(binding.txtUser.editableText.isEmpty()||binding.txtPass.editableText.isEmpty()){
            Toast.makeText(this,"Completa ambos datos para ingresar",Toast.LENGTH_SHORT).show()
        }else   {
            setData()
        }
    }

    fun mostrarInfoApp(){
        binding.imgPrincipal.isVisible=false
    }

    fun validacionEmail(): Boolean{
      val email = binding.txtUser.editableText?.toString()
         if(email.isEmpty()){
            binding.txtUser.error="El campo no puede estar vacio"
        }
    return false
    }


}


