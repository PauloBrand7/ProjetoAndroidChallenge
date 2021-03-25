package com.desafio.githubchallenge.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.desafio.githubchallenge.R
import com.desafio.githubchallenge.model.Repositorio

class DetailedRepositoryActivity : AppCompatActivity() {

    private lateinit var titleRepository : TextView
    private lateinit var forkRepository : TextView
    private lateinit var starRepository : TextView
    private lateinit var authorRepository : TextView
    private lateinit var icon : ImageView
    private lateinit var likeButton : ImageButton
    private lateinit var shareButton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_repository)
    }

    override fun onResume() {
        super.onResume()
        val repositories = intent.getParcelableExtra<Repositorio>("repositoryObject")

        titleRepository = findViewById(R.id.titulo_repositorio)
        forkRepository = findViewById(R.id.forks_repositorio)
        starRepository = findViewById(R.id.estrelas_repositorio)
        authorRepository = findViewById(R.id.autor_repositorio)
        icon = findViewById(R.id.icone_repositorio)
        likeButton= findViewById(R.id.likeButton)
        shareButton = findViewById(R.id.shareButton)

        setView(repositories)
        toastButtons(likeButton, repositories, shareButton)

    }

    private fun setView(repositories: Repositorio?) {
        title = repositories?.nomeRepos
        repositories?.let { icon.setImageResource(it.icone) }
        titleRepository.text = repositories?.nomeRepos
        forkRepository.text = StringBuilder().append(resources.getString(R.string.forks)).append(repositories?.forks)
        starRepository.text = StringBuilder().append(resources.getString(R.string.stars)).append(repositories?.stars)
        authorRepository.text = StringBuilder().append(resources.getString(R.string.autor)).append(repositories?.autor)
    }

    private fun toastButtons(likeButton: ImageButton, repositories: Repositorio?, shareButton: ImageButton) {
        likeButton.setOnClickListener {
            Toast.makeText(this, StringBuilder().append(resources.getString(R.string.toast_like)).append(repositories?.nomeRepos), Toast.LENGTH_SHORT).show()
        }

        shareButton.setOnClickListener {
            Toast.makeText(this, StringBuilder().append(resources.getString(R.string.toast_share)).append(repositories?.nomeRepos), Toast.LENGTH_SHORT).show()
        }
    }

}