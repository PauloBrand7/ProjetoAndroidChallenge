package com.desafio.githubchallenge.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.desafio.githubchallenge.R
import com.desafio.githubchallenge.model.Repositorio
import com.desafio.githubchallenge.ui.recyclerview.RepositorioAdapter
import com.desafio.githubchallenge.ui.viewmodel.MainViewModel


class MainActivity : AppCompatActivity(){

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

    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }

    private fun liveDataConfigure() {
        viewModel.repositoriosLiveData.observe(this, Observer {
            rvList.apply {
                adapter = RepositorioAdapter(it,::onClick, ::forkColors)
            }
        })
    }

    private fun onClick(repositorio : Repositorio) {
        val intent = Intent(this,DetailedRepositoryActivity ::class.java)
        intent.putExtra("repositorioObject",repositorio)
        startActivity(intent)
    }

    private fun forkColors(value : String): Int {
        return when (value.toInt()) {
            in 0..10 -> R.drawable.shape_low_fork_cardview
            in 11..60 -> R.drawable.shape_medium_fork_cardview
            else -> R.drawable.shape_high_fork_cardview
        }
    }

}
