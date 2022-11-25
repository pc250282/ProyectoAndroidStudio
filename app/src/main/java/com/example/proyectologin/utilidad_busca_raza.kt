package com.example.proyectologin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectologin.databinding.ActivityUtilidadBuscaRazaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class utilidad_busca_raza : AppCompatActivity(),SearchView.OnQueryTextListener {

    private lateinit var binding:ActivityUtilidadBuscaRazaBinding
    private lateinit var adapter: DogsAdapter
    private val dogImages= mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUtilidadBuscaRazaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svDogs.setOnQueryTextListener(this)
        if (binding.svDogs.isEmpty()){
            Toast.makeText(this,"Ingresa la raza a buscar",Toast.LENGTH_SHORT).show()
        }else{
            initRecyclerView()
        }


    }

    private fun initRecyclerView() {
    adapter= DogsAdapter(dogImages)
        binding.rvDogs.layoutManager=LinearLayoutManager(this)
        binding.rvDogs.adapter=adapter

    }

    //Intanciamos retrofit
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//funcion para buscar
    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call:Response<DogsResponse> = getRetrofit().create(APIService::class.java).getDogsByBreeds("$query/images")
            val puppies:DogsResponse? = call.body()
            runOnUiThread{
                if(call.isSuccessful){
                val images: List<String> = puppies?.images ?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                }
                else{
                    mostrarError()
                }
            }
            esconderTeclado()
        }
    }

    private fun mostrarError(){
        Toast.makeText(this,"Ha ocurrido un error",Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByName(query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
    //Esconde el teclado luego de una busqueda
    fun esconderTeclado(){
        val inm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(binding.pantallaPrincipal.windowToken,0)
    }

}