package com.example.proyectologin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class RegistroDatos : AppCompatActivity() {
    private val listaUsuariosArrayList=ArrayList<Usuario>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_datos)

        val btnGuardar=findViewById<Button>(R.id.btnGuardar)
        val sltCondiciones=findViewById<Switch>(R.id.sltCondiciones)

        btnGuardar.setOnClickListener {
            it.esconderTeclado()
            if(sltCondiciones.isChecked)
            setDatos()
            else{
                Toast.makeText(this,"DEBE ACEPTAR LAS CONDICIONES", Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun setDatos(){
        val usuarioNuevo=Usuario()
        val txtNombre=findViewById<TextView>(R.id.txtNombre)
        val txtApellido=findViewById<TextView>(R.id.txtApellido)
        val txtDocumento=findViewById<TextView>(R.id.txtDocumento)
        val txtDireccion=findViewById<TextView>(R.id.txtDireccion)
        val txtEmail=findViewById<EditText>(R.id.txtEmail)
        val txtPassword=findViewById<EditText>(R.id.txtPassword2)
        usuarioNuevo.nombre=txtNombre.text.toString()
        usuarioNuevo.apellido=txtApellido.text.toString()
        usuarioNuevo.direccion=txtDireccion.text.toString()
        usuarioNuevo.documento=txtDocumento.text.toString()
        usuarioNuevo.mail=txtEmail.text.toString()






        val intent= Intent(this,MostrarDatosPersona::class.java)
        intent.putExtra("usuario",usuarioNuevo)
        startActivity(intent)
    }

}