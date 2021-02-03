package com.desafio.githubchallenge

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.desafio.githubchallenge.model.repositorio

class MainViewModel : ViewModel() {

    val repositoriosLiveData : MutableLiveData<List<repositorio>> = MutableLiveData()

    fun getRepositorios(){
        repositoriosLiveData.value = criaLista()
    }

    fun criaLista() : List<repositorio>{
        return  mutableListOf(
                repositorio(nomeRepos = "archicture-samples",stars = "38013", forks = "10507", autor = "android", icone = 0 /* "imgur.com/ncoFlOw.png" */),
                repositorio(nomeRepos = "shadowsocks-android",stars = "30845", forks = "11361", autor = "shadowsocks", icone = 1/*"imgur.com/4KMlKaE.png" */),
                repositorio(nomeRepos = "leakcanary",stars = "25639", forks = "3709", autor = "square", icone = 2/*"imgur.com/bsgJEfX.png" */),
                repositorio(nomeRepos = "p3c",stars = "24269", forks = "6468", autor = "alibaba", icone =3 /*"imgur.com/eFHRYba.png" */),
                repositorio(nomeRepos = "iosched",stars = "20255", forks = "6102", autor = "android", icone = 4/*"imgur.com/oR9HnGz.jpg" */),
                repositorio(nomeRepos = "architecture-components-samples",stars = "19163", forks = "6716", autor = "android", icone = 0 /*"imgur.com/ncoFlOw.png" */),
                repositorio(nomeRepos = "material-dialogs",stars = "38013", forks = "10507", autor = "Paulo Brand", icone = 5 /*"imgur.com/ksuYxt6.jpg" */)

        )
    }

}