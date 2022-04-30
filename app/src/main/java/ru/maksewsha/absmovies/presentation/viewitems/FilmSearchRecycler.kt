package ru.maksewsha.absmovies.presentation.viewitems

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.maksewsha.absmovies.R
import ru.maksewsha.absmovies.presentation.fragments.FilmFullFragment
import ru.maksewsha.absmovies.presentation.models.FilmUIFiltersFull
import ru.maksewsha.absmovies.presentation.utils.getStringList

class FilmSearchRecycler(private val films: List<FilmUIFiltersFull>) :
    RecyclerView.Adapter<FilmSearchRecycler.FilmSearchViewHolder>() {

    class FilmSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.card_list_entitle_rutitle)
        val image: ImageView = itemView.findViewById(R.id.card_list_image)
        val rating: TextView = itemView.findViewById(R.id.card_list_rating)
        val countryYear: TextView = itemView.findViewById(R.id.card_list_country_year)
        val genreType: TextView = itemView.findViewById(R.id.card_list_genre_type)
        val cardItem: CardView = itemView.findViewById(R.id.film_item_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmSearchViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_film, parent, false)
        return FilmSearchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilmSearchViewHolder, position: Int) {
        holder.title.text = if (films.get(position).nameRu != null) {
            "${films.get(position).nameOriginal} - ${films.get(position).nameRu}"
        } else {
            films.get(position).nameOriginal
        }

        holder.rating.text = films.get(position).ratingImdb.toString()

        holder.countryYear.text =
            "${getStringList(films.get(0).countryDomains)}, ${films.get(position).year}"

        holder.genreType.text =
            "${getStringList(films.get(position).genreDomains)}, ${films.get(position).type?.lowercase()}"

        Glide.with(holder.itemView.context).load(films.get(position).posterURLPreview)
            .override(250, 375)
            .centerCrop()
            .into(holder.image)

        holder.cardItem.setOnClickListener {
            (holder.itemView.parent as Fragment).parentFragmentManager.beginTransaction().replace(R.id.fragment_container, FilmFullFragment(), //TODO,"FilmFullFragment")
        }
    }

    override fun getItemCount(): Int {
        return films.size
    }
}