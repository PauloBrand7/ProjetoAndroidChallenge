package com.desafio.githubchallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.desafio.githubchallenge.model.Repositorio

class MainViewModel : ViewModel() {

    val repositoriosLiveData: LiveData<List<Repositorio>>
        get() = _repositoriosLiveData
    private val _repositoriosLiveData = MutableLiveData<List<Repositorio>>()

    fun fetchRepositories(){
        _repositoriosLiveData.value = criaLista()
    }

    fun getRepositorios(): LiveData<List<Repositorio>> {
        _repositoriosLiveData.value = criaLista()
        return repositoriosLiveData
    }

    private fun criaLista() : List<Repositorio> {
        return  arrayListOf(
            Repositorio(
                nomeRepos = "archicture-samples",
                stars = "38013",
                forks = "10507",
                autor = "android",
                icone = 0
            ),
            Repositorio(
                nomeRepos = "shadowsocks-android",
                stars = "30845",
                forks = "11361",
                autor = "shadowsocks",
                icone = 1
            ),
            Repositorio(
                nomeRepos = "leakcanary",
                stars = "25639",
                forks = "3709",
                autor = "square",
                icone = 2
            ),
            Repositorio(
                nomeRepos = "p3c",
                stars = "24269",
                forks = "6468",
                autor = "alibaba",
                icone = 3
            ),
            Repositorio(
                nomeRepos = "iosched",
                stars = "20255",
                forks = "6102",
                autor = "android",
                icone = 4
            ),
            Repositorio(
                nomeRepos = "architecture-components-samples",
                stars = "19163",
                forks = "6716",
                autor = "android",
                icone = 0
            ),
            Repositorio(
                nomeRepos = "material-dialogs",
                stars = "38013",
                forks = "10507",
                autor = "Paulo Brand",
                icone = 5
            )

        )
    }

}