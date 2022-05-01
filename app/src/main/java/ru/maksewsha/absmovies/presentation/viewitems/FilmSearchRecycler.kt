package ru.maksewsha.absmovies.presentation.viewitems

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.maksewsha.absmovies.R
import ru.maksewsha.absmovies.presentation.fragments.FilmFullFragment
import ru.maksewsha.absmovies.presentation.fragments.SearchFragment
import ru.maksewsha.absmovies.presentation.models.FilmUIFiltersFull
import ru.maksewsha.absmovies.presentation.utils.getStringList
import ru.maksewsha.absmovies.presentation.viewmodels.SearchViewModel

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

        val viewModel =
            ViewModelProvider((holder.itemView.context as AppCompatActivity)).get(SearchViewModel::class.java)

        holder.title.text = if (films.get(position).nameRu != null) {
            "${films.get(position).nameOriginal} - ${films.get(position).nameRu}"
        } else {
            films.get(position).nameOriginal
        }

        holder.rating.text = films.get(position).ratingImdb.toString()

        holder.countryYear.text =
            "${getStringList(films.get(position).countryDomains)}, ${films.get(position).year}"

        holder.genreType.text =
            "${getStringList(films.get(position).genreDomains)}, ${films.get(position).type?.lowercase()}"

        Glide.with(holder.itemView.context).load(films.get(position).posterURLPreview)
            .override(250, 375)
            .centerCrop()
            .into(holder.image)

        holder.cardItem.setOnClickListener {
            val fragmentToShow = FilmFullFragment()
            val bundle = Bundle()
            bundle.putLong("filmId", films.get(position).kinopoiskID)
            fragmentToShow.arguments = bundle
            (holder.itemView.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragmentToShow,    "FilmFullFragment").commit()
        }
    }

    override fun getItemCount(): Int {
        return films.size
    }
}