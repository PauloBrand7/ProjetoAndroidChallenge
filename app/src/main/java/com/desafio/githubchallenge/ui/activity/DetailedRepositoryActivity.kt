package com.desafio.githubchallenge.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.desafio.githubchallenge.R
import com.desafio.githubchallenge.model.Repositorio

class DetailedRepositoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_repository)


        val repositories = intent.getParcelableExtra<Repositorio>("repositorioObject")
        val titleRepository : TextView = findViewById(R.id.titulo_repositorio)
        val forkRepository : TextView = findViewById(R.id.forks_repositorio)
        val starRepository : TextView = findViewById(R.id.estrelas_repositorio)
        val authorRepository : TextView = findViewById(R.id.autor_repositorio)
        val icon : ImageView =findViewById(R.id.icone_repositorio)
        val star: ImageView = findViewById(R.id.estrela_image)
        val fork: ImageView = findViewById(R.id.fork_image)
        val likeButton : ImageButton = findViewById(R.id.likeButton)
        val shareButton : ImageButton = findViewById(R.id.shareButton)


        title = repositories?.nomeRepos
        star.setImageResource(R.drawable.star)
        fork.setImageResource(R.drawable.fork)
        repositories?.let { icon.setImageResource(it.icone) }
        titleRepository.text = repositories?.nomeRepos
        forkRepository.text = repositories?.forks
        starRepository.text = repositories?.stars
        authorRepository.text = repositories?.autor

        toastButtons(likeButton, repositories, shareButton)

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