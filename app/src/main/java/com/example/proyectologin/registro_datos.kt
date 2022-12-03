package com.example.proyectologin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.util.PatternsCompat
import com.example.proyectologin.databinding.ActivityMainBinding
import com.example.proyectologin.databinding.ActivityRegistroDatosBinding
import java.util.regex.Pattern

class registro_datos : AppCompatActivity() {
    lateinit var binding: ActivityRegistroDatosBinding
    private val listaUsuariosArrayList = ArrayList<Usuario>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnGuardar.setOnClickListener {
            it.esconderTeclado()
            validaciones()
        }

    }


    fun setDatos(){
        val usuarioNuevo=Usuario()
        usuarioNuevo.nombre=binding.txtNombre.text.toString()
        usuarioNuevo.apellido=binding.txtApellido.text.toString()
        usuarioNuevo.direccion=binding.txtDireccion.text.toString()
        usuarioNuevo.documento=binding.txtDocumento.text.toString()
        usuarioNuevo.mail=binding.txtEmail.text.toString()

        val intent= Intent(this,mostrar_datos_persona::class.java)
        intent.putExtra("usuario",usuarioNuevo)
        startActivity(intent)
    }

    fun validaciones(){
        if (binding.txtNombre.text.isEmpty() || binding.txtApellido.text.isEmpty() ||
            binding.txtDireccion.text.isEmpty() || binding.txtDocumento.text.isEmpty()){
            Toast.makeText(this,"DEBES COMPLETAR TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show()
            }
        else if(validacionEmail() && validacionPassword()) {
            if(binding.txtPassword1.text.toString().equals(binding.txtPassword2.text.toString())){
                    setDatos()
                }else{
                    Toast.makeText(this,"LAS CONTRASEÑAS NO COINCIDEN", Toast.LENGTH_SHORT).show()
                }
            }
    }



    fun validacionPassword(): Boolean {
        val password = binding.txtPassword1.editableText.toString()
        //Creo un patron con expresiones regulares para validar la contraseña
        val passwordRegex= Pattern.compile("^" +
                "(?=.*[@#$%^&+=])" +     // Con 1 caracter especial de esa lista
                "(?=\\S+$)" +            // Sin espacios en blanco
                ".{4,}" +                // mas de 4 caracteres
                "$"
        )
        return if (password.isEmpty()){
            binding.txtPassword1.error="El campo no puede estar vacio"
            false
        }else if(!passwordRegex.matcher(password).matches()){
            binding.txtPassword1.error="El password es demasido sencillo"
            false
        }
        else{
            binding.txtPassword1.error=null
            true
        }
    }

    fun validacionEmail(): Boolean{
        val email = binding.txtEmail.editableText.toString()
        return if(email.isEmpty()){
            binding.txtEmail.error="El campo no puede estar vacio"
            false
        }else if(!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
            /*La clase patter almacena patrones regulares, valida el mail y retorna true si hay
            concidencia con las expresiones regulares o false sino lo seteamos en falso para invertir la repuesta*/
            binding.txtEmail.error="Escribe  un  correo electronico valido"
            false
        }else{
            binding.txtEmail.error=null
            true
        }
    }
}