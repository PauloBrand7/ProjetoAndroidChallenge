package com.desafio.githubchallenge.ui.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.desafio.githubchallenge.R
import com.desafio.githubchallenge.model.Repositorio

class RepositorioAdapter(
    private val repositorios: List<Repositorio>,
    private val onClick: ((Repositorio) -> Unit),
    private val forkColors: ((String) -> Int)
): Adapter<RepositorioAdapter.ViewHolder>(){

    override fun getItemCount(): Int = repositorios.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repositorios[position], onClick)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val avatar: ImageView = view.findViewById(R.id.avatar)
        private val star: ImageView = view.findViewById(R.id.estrela_image)
        private val fork: ImageView = view.findViewById(R.id.fork_image)
        private val autor: TextView = view.findViewById(R.id.autor_repositorio)
        private val nomeRepos: TextView = view.findViewById(R.id.titulo_repositorio)
        private val forks: TextView = view.findViewById(R.id.forks_repositorio)
        private val stars: TextView = view.findViewById(R.id.estrelas_repositorio)

        fun bind(dao: Repositorio, onClick: (Repositorio) -> Unit) {
            Glide.with(itemView).load(dao.icone).circleCrop().into(avatar)
            star.setImageResource(R.drawable.star)
            fork.setImageResource(R.drawable.fork)
            autor.text = dao.autor
            nomeRepos.text = dao.nomeRepos
            forks.text = dao.forks
            stars.text = dao.stars

            itemView.setBackgroundResource(forkColors(dao.forks.toString()))
            itemView.setOnClickListener {
                onClick(dao)
            }
        }
    }
}
