package ru.maksewsha.absmovies.presentation.viewitems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.maksewsha.absmovies.R
import ru.maksewsha.absmovies.presentation.models.FilmUIFiltersFull

class FilmSearchRecycler(private val films: List<FilmUIFiltersFull>):
    RecyclerView.Adapter<FilmSearchRecycler.FilmSearchViewHolder>() {

    class FilmSearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.card_list_rutitle_entitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmSearchViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_film, parent, false)
        return FilmSearchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilmSearchViewHolder, position: Int) {
        holder.title.text = films.get(position).nameRu
    }

    override fun getItemCount(): Int {
        return films.size
    }
}