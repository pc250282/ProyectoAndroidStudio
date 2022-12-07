package com.example.proyectologin

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import com.example.proyectologin.databinding.ActivityAppInfoBinding
import java.net.URI


class App_info : AppCompatActivity() {
    private lateinit var binding: ActivityAppInfoBinding
    var mensaje:String="Objetivo:\n -Crear varias pantallas y podes enviar objetos\n" +
            "-Aplicar conocimientos de programacion para validar datosingresados\n" +
            " -Utilizar pantallas con varios elementos y personalizarlos\n" +
            " -Consumir una API y podes obtener una repuesta y mostrar el resultado\n\n\n\n\n" +
            "Librerias  utilizadas: \n" +
            "Retrofit 2, GsonConverter, Picasso\n" +
            "Api utilizada: https://dog.ceo/dog-api/\n\n\n\n\n\n\n"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_info)

        binding=ActivityAppInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtAppInfo.setText(mensaje)


        //Boton para ir a la URL de la api
        binding.btnVisitarApi.setOnClickListener{
            var url:String="https://dog.ceo/api/"
            var intent = Intent()
            intent.setAction(ACTION_VIEW)
            intent.setData(Uri.parse(url))
            startActivity(intent)
        }

        //Vuelvo al incio destruyo activity
        binding.btnVolverInicio.setOnClickListener{
            finish()
        }
    }
}