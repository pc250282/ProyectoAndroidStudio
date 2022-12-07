package com.example.proyectologin

import com.google.gson.annotations.SerializedName

/*Modelo de datos obtenido de la documentacion de la API, nos devuelve un campo status="success"
y una listra de strings y con serialized puedo el "message" obtenido mapearlo en la variable images */


data class DogsResponse (@SerializedName("status") var status:String,
                         @SerializedName("message") var images: List<String>)
