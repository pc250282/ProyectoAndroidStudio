package com.example.proyectologin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


//Creamos un adaptador que va recibe una lista de strings
class DogsAdapter(val images:List<String>):RecyclerView.Adapter<DogViewHolder>() {

    //La imagen que va a mostrar del layout item_dog
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
       val layoutInflater:LayoutInflater= LayoutInflater.from(parent.context)
        return DogViewHolder(layoutInflater.inflate(R.layout.item_dog,parent,false))
    }
    //Tamaño de imagen
    override fun getItemCount(): Int =images.size

    //Posicion de la imagen
    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val item=images[position]
        holder.bind(item)
    }



}