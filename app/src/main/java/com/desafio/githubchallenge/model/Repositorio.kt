package com.desafio.githubchallenge.model

import androidx.annotation.DrawableRes

data class Repositorio(
    var autor : String,
    var nomeRepos : String,
    var forks : String,
    var stars : String,
    @DrawableRes
    var icone : Int
)
