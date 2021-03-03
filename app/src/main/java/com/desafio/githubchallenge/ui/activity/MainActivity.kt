package com.desafio.githubchallenge.ui.activity

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.desafio.githubchallenge.R
import com.desafio.githubchallenge.ui.recyclerview.RepositorioAdapter
import com.desafio.githubchallenge.ui.viewmodel.MainViewModel

// TODO: a pasta .idea ainda está no seu repo remoto, remova ela - OK

class MainActivity : AppCompatActivity(){

    // TODO: Atentar ao uso de variáveis globais
    //TODO: usar sempre a lingua inglesa para nomear os nomes da variáveis, classes e métodos

    private lateinit var viewModel: MainViewModel
    private lateinit var rvList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        rvList = findViewById(R.id.activity_cards)
        liveDataConfigure()
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchRepositories()
    }

    private fun liveDataConfigure() {
        viewModel.repositoriosLiveData.observe(this, Observer {
            rvList.apply {
                adapter = RepositorioAdapter(it,::onClick, ::forkColors)
            }
        })
    }

    // TODO: se ligar na privacidade dos itens que tu implementa - OK
    private fun onClick(message: String) {
        Toast.makeText(this, StringBuilder().append(resources.getString(R.string.toast_repositorios)).append(message), Toast.LENGTH_SHORT).show()
    }

    private fun forkColors(value : String): Int {
        return when (value.toInt()) {
            in 0..10 -> R.drawable.shape_low_fork_cardview
            in 11..60 -> R.drawable.shape_medium_fork_cardview
            else -> R.drawable.shape_high_fork_cardview
        }
    }

}
