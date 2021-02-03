package com.desafio.githubchallenge.model

import android.content.Context
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.desafio.githubchallenge.R

class RepositorioAdapter(private var ctx: Context, private val repositorios: List<repositorio>) : BaseAdapter() {

    override fun getCount(): Int = repositorios.size
    override fun getItem(position: Int): Any = repositorios[position]
    override fun getItemId(position: Int): Long = position.toLong()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val icones : TypedArray by lazy { ctx.resources.obtainTypedArray(R.array.iconesNumerados) } // Enumera os icones em um Array
        val dao = repositorios[position]
        val row = LayoutInflater.from(ctx).inflate(R.layout.card_item,parent,false)

        val avatar : ImageView = row.findViewById(R.id.avatar)
        Glide.with(ctx)
            .load(icones.getDrawable(dao.icone))
            .circleCrop()
            .into(avatar)

        val star : ImageView = row.findViewById(R.id.estrela_image)
        val fork : ImageView = row.findViewById(R.id.fork_image)
        val autor :  TextView = row.findViewById(R.id.autor_repositorio)
        val nomeRepos : TextView = row.findViewById(R.id.titulo_repositorio)
        val forks : TextView = row.findViewById(R.id.forks_repositorio)
        val stars : TextView = row.findViewById(R.id.estrelas_repositorio)

        star.setImageResource(R.drawable.star)
        fork.setImageResource(R.drawable.fork)
        autor.text = dao.autor
        nomeRepos.text = dao.nomeRepos
        forks.text = dao.forks
        stars.text = dao.stars

        return row

    }

}