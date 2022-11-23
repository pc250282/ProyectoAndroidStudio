package com.example.proyectologin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class mostrar_datos_persona : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_mostrar_datos_persona)
        val lblNombre=findViewById<TextView>(R.id.lblNombre)
        val lblApellido=findViewById<TextView>(R.id.lblApellido)
        val lblDocumento=findViewById<TextView>(R.id.lblDocumento)
        val lblDireccion=findViewById<TextView>(R.id.lblDireccion)
        val lblMail=findViewById<TextView>(R.id.lblMail)
        val btnVolver=findViewById<Button>(R.id.btnVolver)
        super.onCreate(savedInstanceState)
        val usuarioRecibido=intent.getParcelableExtra<Usuario>("usuario")

        if(usuarioRecibido!=null){


            lblNombre.setText(usuarioRecibido.nombre)
            lblApellido.setText(usuarioRecibido.apellido)
            lblDocumento.setText(usuarioRecibido.documento)
            lblDireccion.setText(usuarioRecibido.direccion)
            lblMail.setText(usuarioRecibido.mail)

            btnVolver.setOnClickListener {
                val intent = Intent(this, menu_usuario::class.java)
                intent.putExtra("mostrar",usuarioRecibido)
                startActivity(intent)
            }
        }



    }
}