package com.desafio.githubchallenge

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.desafio.githubchallenge.model.RepositorioAdapter
import com.desafio.githubchallenge.model.repositorio


class MainActivity : AppCompatActivity() {

    val TITULO_APPBAR = "GitHub Challenge"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        setTitle(TITULO_APPBAR)
        val bar = supportActionBar
        val cor = ColorDrawable(Color.parseColor("#643cb4"))
        bar!!.setBackgroundDrawable(cor)

        val viewModel: MainViewModel = ViewModelProviders.of(this).get(MainViewModel ::class.java)
        val lista : ListView = findViewById(R.id.list_cards);

        viewModel.repositoriosLiveData.observe(this, Observer{
            it?.let {
                lista.adapter = RepositorioAdapter(this,viewModel.criaLista())
            }
        })

        lista.setOnItemClickListener{ parent, view, position, id ->
            val listaRepositorios:List<repositorio> = viewModel.criaLista()
            Toast.makeText(this,"Repositorio clicado: ${listaRepositorios[position].nomeRepos}",Toast.LENGTH_SHORT).show()
        }

        viewModel.getRepositorios()

    }
}

