package com.desafio.githubchallenge.ui.recyclerview

import android.content.res.TypedArray
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
    private val icones: TypedArray,
    private val onClick: ((String) -> Unit)
): Adapter<RepositorioAdapter.ViewHolder>(){

    override fun getItemCount(): Int = repositorios.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false))

    // TODO: onBindViewHolder não retorna nada
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repositorios[position], onClick, icones)
    }

    inner class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) { //Nested Class // Nested tu tem que usar o inner
        // TODO: Alterar a privacidade deles
        val avatar: ImageView = view.findViewById(R.id.avatar)
        val star: ImageView = view.findViewById(R.id.estrela_image)
        val fork: ImageView = view.findViewById(R.id.fork_image)
        val autor: TextView = view.findViewById(R.id.autor_repositorio)
        val nomeRepos: TextView = view.findViewById(R.id.titulo_repositorio)
        val forks: TextView = view.findViewById(R.id.forks_repositorio)
        val stars: TextView = view.findViewById(R.id.estrelas_repositorio)

        fun bind(dao: Repositorio, onClick: ((String) -> Unit), icones: TypedArray) {
            Glide.with(itemView).load(icones.getDrawable(dao.icone)).circleCrop().into(avatar)
            star.setImageResource(R.drawable.star)
            fork.setImageResource(R.drawable.fork)
            autor.text = dao.autor
            nomeRepos.text = dao.nomeRepos
            forks.text = dao.forks
            stars.text = dao.stars

            itemView.setOnClickListener {
                onClick(dao.nomeRepos)
            }
        }
    }
}
