package com.example.proyectologin

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.proyectologin.databinding.ActivityMostrarDatosPersonaBinding
import com.example.proyectologin.databinding.ActivityUtilidadBuscaRazaBinding

class mostrar_datos_persona : AppCompatActivity() {
    private lateinit var binding:ActivityMostrarDatosPersonaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMostrarDatosPersonaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioRecibido=intent.getParcelableExtra<Usuario>("usuario")

        if(usuarioRecibido!=null){
            
            binding.lblNombre.setText(usuarioRecibido.nombre)
            binding.lblApellido.setText(usuarioRecibido.apellido)
            binding.lblDocumento.setText(usuarioRecibido.documento)
            binding.lblDireccion.setText(usuarioRecibido.direccion)
            binding.lblMail.setText(usuarioRecibido.mail)
            }

        binding.btnGuardaUsuario.setOnClickListener{
            val intent = Intent(this, menu_usuario::class.java)
            intent.putExtra("mostrar", usuarioRecibido)
            Toast.makeText(this,"DATOS GUARDADOS", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        binding.btnVolver.setOnClickListener {
            onBackPressed()
        }






    }
}