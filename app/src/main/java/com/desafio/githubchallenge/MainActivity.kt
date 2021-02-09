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

//TODO: pesquise pelo apply ou o with do koltin, com eles tu pode melhorar muito seu codigo
//TODO: criar metodos para cada acao feita no onCreate, deixe ele mais limpo
//TODO: procure usar os outros metodos do ciclo de vida
//TODO: organizar melhor o seu código
//TODO: evitar usar o !!
class MainActivity : AppCompatActivity() {

    // TODO: usar const
    val TITULO_APPBAR = "GitHub Challenge"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        setTitle(TITULO_APPBAR)
        val bar = supportActionBar
        //TODO: usar os colors.xml, ou tu pode pesquisar sobre styles, pois a cor da toolbar é pela cor no Theme: colorPrimary, basta mudar ela
        val cor = ColorDrawable(Color.parseColor("#643cb4"))
        //TODO: esse atributo tu pode setar no layout/view
        bar!!.setBackgroundDrawable(cor)

        //TODO: seu viewModel não faz muito sentido, estude um pouco sobre livedata
        val viewModel: MainViewModel = ViewModelProviders.of(this).get(MainViewModel ::class.java)
        val lista : ListView = findViewById(R.id.list_cards);

        viewModel.repositoriosLiveData.observe(this, Observer{
            it?.let {
                //TODO: errado
                //lista.adapter = RepositorioAdapter(this,viewModel.criaLista())
                //TODO: correto
                lista.adapter = RepositorioAdapter(this,it)
            }
        })

        //TODO: essa forma não garante que o click foi no local correto
        //TODO: usar callback para o click no item
        lista.setOnItemClickListener{ parent, view, position, id ->
            val listaRepositorios:List<repositorio> = viewModel.criaLista()
            //TODO: usar os strings.xml, pesquisar como concatenar strings de forma dinamica (string builder)
            Toast.makeText(this,"Repositorio clicado: ${listaRepositorios[position].nomeRepos}",Toast.LENGTH_SHORT).show()
        }

        // TODO: veja se não seria melhor chamar isso no onResume e por que
        viewModel.getRepositorios()

    }
}

