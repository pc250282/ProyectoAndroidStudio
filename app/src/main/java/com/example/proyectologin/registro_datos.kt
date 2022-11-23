package com.example.proyectologin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.proyectologin.databinding.ActivityMainBinding
import com.example.proyectologin.databinding.ActivityRegistroDatosBinding

class registro_datos : AppCompatActivity() {
    lateinit var binding: ActivityRegistroDatosBinding
    private val listaUsuariosArrayList=ArrayList<Usuario>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegistroDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnGuardar.setOnClickListener {
            it.esconderTeclado()
            if(binding.sltCondiciones.isChecked)
            setDatos()
            else{
                Toast.makeText(this,"DEBE ACEPTAR LAS CONDICIONES", Toast.LENGTH_SHORT).show()
            }

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

}