package com.example.proyectologin


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    fun getDogsByBreeds(@Url url:String):Response<DogsResponse>
}