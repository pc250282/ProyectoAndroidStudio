package com.example.proyectologin

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectologin.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

//Recibe la view que vamos a llenar con las imagenes
class DogViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding= ItemDogBinding.bind(view)

    /*Esto es por cada celda que vamos a mostrar en el recyclerview y con picasso convertimos
    el string en la imagen*/
    fun bind(image:String){
        Picasso.get().load(image).into(binding.ivDog)
    binding.ivDog
    }
}