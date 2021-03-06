package com.desafio.githubchallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.desafio.githubchallenge.R
import com.desafio.githubchallenge.model.Repositorio

class MainViewModel : ViewModel() {

    val repositoriosLiveData: LiveData<List<Repositorio>>
        get() = _repositoriosLiveData
    private val _repositoriosLiveData = MutableLiveData<List<Repositorio>>()

    fun fetchRepositories(){
        _repositoriosLiveData.value = criaLista()
    }

    private fun criaLista() : List<Repositorio> {
        return  arrayListOf(
            Repositorio(
                nomeRepos = "archicture-samples",
                stars = "380",
                forks = "8",
                autor = "android",
                icone = R.drawable.android
            ),
            Repositorio(
                nomeRepos = "shadowsocks-android",
                stars = "308",
                forks = "55",
                autor = "shadowsocks",
                icone = R.drawable.shadowsocks
            ),
            Repositorio(
                nomeRepos = "leakcanary",
                stars = "256",
                forks = "62",
                autor = "square",
                icone = R.drawable.square
            ),
            Repositorio(
                nomeRepos = "p3c",
                stars = "242",
                forks = "64",
                autor = "alibaba",
                icone = R.drawable.alibaba
            ),
            Repositorio(
                nomeRepos = "iosched",
                stars = "202",
                forks = "5",
                autor = "android",
                icone = R.drawable.google
            ),
            Repositorio(
                nomeRepos = "architecture-components-samples",
                stars = "191",
                forks = "99",
                autor = "android",
                icone = R.drawable.android
            ),
            Repositorio(
                nomeRepos = "material-dialogs",
                stars = "380",
                forks = "10",
                autor = "Paulo Brand",
                icone = R.drawable.icone
            )

        )
    }

}