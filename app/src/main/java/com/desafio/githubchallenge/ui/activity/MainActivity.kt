package com.desafio.githubchallenge.ui.activity

import android.content.res.TypedArray
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desafio.githubchallenge.R
import com.desafio.githubchallenge.ui.recyclerview.RepositorioAdapter
import com.desafio.githubchallenge.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(){

    companion object {
        const val titleAppBar = "GitHub Challenge"  // TODO: usar const -  OK
    }

    override fun onCreate(savedInstanceState: Bundle?) { //TODO: criar metodos para cada acao feita no onCreate, deixe ele mais limpo - OK
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val lista : RecyclerView = findViewById(R.id.activity_cards)
        val icones  = resources.obtainTypedArray(R.array.iconesNumerados)

        title = titleAppBar
        liveDataConfigure(viewModel, lista, icones)
    }

    private fun liveDataConfigure(viewModel: MainViewModel, lista: RecyclerView, icones: TypedArray) {
        viewModel.getRepositorios().observe(
            this,
            Observer { lista.adapter = RepositorioAdapter(it, icones, ::onClick)} //TODO: usar callback para o click no item - OK
        )
    }

    fun onClick(message : String) {//TODO: usar os strings.xml, pesquisar como concatenar strings de forma dinamica (string builder) - OK
        Toast.makeText(this, StringBuilder().append(resources.getString(R.string.toast_repositorios)).append(message), Toast.LENGTH_SHORT).show()
        Log.i("toast","Toast Enviado")
    }

}

//TODO: evitar usar o !! - OK
//TODO: organizar melhor o seu código
//TODO: procure usar os outros metodos do ciclo de vida
//TODO: pesquise pelo apply ou o with do koltin, com eles tu pode melhorar muito seu codigo
//TODO: seu viewModel não faz muito sentido, estude um pouco sobre livedata
// TODO: procurar sobre o padrão de projeto factory para criar blocos de teste