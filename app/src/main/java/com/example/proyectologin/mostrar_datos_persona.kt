package com.example.proyectologin

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectologin.databinding.ActivityMostrarDatosPersonaBinding


class mostrar_datos_persona : AppCompatActivity() {
    private lateinit var binding:ActivityMostrarDatosPersonaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMostrarDatosPersonaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioRecibido=intent.getParcelableExtra<Usuario>("usuario")

        if(usuarioRecibido!=null){
            
            binding.lblNombre.setText("NOMBRE: "+usuarioRecibido.nombre)
            binding.lblApellido.setText("APELLIDO: "+usuarioRecibido.apellido)
            binding.lblDocumento.setText("DOCUMENTO: "+usuarioRecibido.documento)
            binding.lblDireccion.setText("DIRECCION: "+usuarioRecibido.direccion)
            binding.lblMail.setText("USUARIO: "+usuarioRecibido.mail)
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