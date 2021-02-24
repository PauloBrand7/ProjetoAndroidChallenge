package com.desafio.githubchallenge.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.desafio.githubchallenge.R
import com.desafio.githubchallenge.ui.recyclerview.RepositorioAdapter
import com.desafio.githubchallenge.ui.viewmodel.MainViewModel

// TODO: a pasta .idea ainda está no seu repo remoto, remova ela

class MainActivity : AppCompatActivity(){

    companion object {
        const val titleAppBar = "GitHub Challenge"
    }

    // TODO: Atentar ao uso de variáveis globais
    //TODO: usar sempre a lingua inglesa para nomear os nomes da variáveis, classes e métodos

    private lateinit var viewModel: MainViewModel
    private val rvList: RecyclerView = findViewById(R.id.activity_cards)
    private val icones = resources.obtainTypedArray(R.array.iconesNumerados)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        title = titleAppBar // TODO: use uma frase vinda do strings.xml
        liveDataConfigure()
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchRepositories()
    }

    private fun liveDataConfigure() {
        viewModel.repositoriosLiveData.observe(this, Observer {
            rvList.apply {
                // TODO: Passar os icones dessa forma não é o
                //  jeito certo, tu deve por os icones no seu modelo e
                //  pegar eles do seu modelo e não de um array do resources
                adapter = RepositorioAdapter(it, icones, ::onClick)
            }
        })
    }

    // TODO: se ligar na privacidade dos itens que tu implementa
    private fun onClick(message: String) {
        Toast.makeText(this, StringBuilder().append(resources.getString(R.string.toast_repositorios)).append(message), Toast.LENGTH_SHORT).show()
    }
}
