package com.example.proyectologin

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.util.PatternsCompat
import androidx.core.view.isVisible
import com.example.proyectologin.databinding.ActivityMainBinding
import java.util.regex.Pattern

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


        //Boton LOGUIN
        binding.btnLogin.setOnClickListener {
            if(validacionEmail()==true){
                setData()
            }
       }

        //Boton para registrar usuario
        binding.btnRegistrarse.setOnClickListener {
            it.esconderTeclado()
            var intent = Intent(this, registro_datos::class.java)
            startActivity(intent)
        }

        //Boton muestra info de la App
        binding.btnInfo.setOnClickListener{
            mostrarInfoApp()
        }
        
    }

    fun setData() {

        var convertStringUser = binding.txtUser.text.toString()
        var convertStringPass = binding.txtPass.text.toString()
        val user1 = Users(convertStringUser, convertStringPass)
        val siguiente=Intent(this, utilidad_busca_raza::class.java)
        siguiente.putExtra("mostrar", user1)
        startActivity(siguiente)

    }

    fun mostrarInfoApp(){
        binding.imgPrincipal.isVisible=false
    }


    fun validacionEmail(): Boolean{
      val email = binding.txtUser.editableText.toString()
        return if(email.isEmpty()){
            binding.txtUser.error="El campo no puede estar vacio"
            false
        }else if(!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
            /*La clase patter almacena patrones regulares, valida el mail y retorna true si hay
            concidencia con las expresiones regulares o false sino lo seteamos en falso para invertir la repuesta*/
             binding.txtUser.error="Escribe  un  correo electronico valido"
            false
        }else{
            binding.txtUser.error=null
            true
        }
    }

}


