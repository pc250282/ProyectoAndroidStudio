package com.example.proyectologin


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

//Esta interfaz tiene el metodo para poder consumir la API, recibe la url y nos devuelve la respuesta
interface APIService {
    @GET
    suspend fun getDogsByBreeds(@Url url:String):Response<DogsResponse>
}