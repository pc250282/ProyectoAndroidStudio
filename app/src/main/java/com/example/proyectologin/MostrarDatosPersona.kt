package com.example.proyectologin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MostrarDatosPersona : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_mostrar_datos_persona)
        var lblNombre=findViewById<TextView>(R.id.lblNombre)
        var lblApellido=findViewById<TextView>(R.id.lblApellido)
        var lblDocumento=findViewById<TextView>(R.id.lblDocumento)
        var lblDireccion=findViewById<TextView>(R.id.lblDireccion)
        var lblMail=findViewById<TextView>(R.id.lblMail)
        var btnVolver=findViewById<Button>(R.id.btnVolver)
        super.onCreate(savedInstanceState)
        var usuarioRecibido=intent.getParcelableExtra<Usuario>("usuario")

        if(usuarioRecibido!=null){


            lblNombre.setText(usuarioRecibido.nombre)

        }

        /*btnVolver.setOnClickListener {
            var intent = Intent(this, SegundaActivity::class.java)
            startActivity(intent)
        }*/

    }
}