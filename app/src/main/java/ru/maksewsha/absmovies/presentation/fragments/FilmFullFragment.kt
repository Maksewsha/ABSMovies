package ru.maksewsha.absmovies.presentation.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ContentInfoCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import ru.maksewsha.absmovies.R
import ru.maksewsha.absmovies.databinding.FragmentFilmFullBinding
import ru.maksewsha.absmovies.presentation.models.FilmUIFull
import ru.maksewsha.absmovies.presentation.utils.setRateColor
import ru.maksewsha.absmovies.presentation.viewmodels.SearchViewModel
import java.text.NumberFormat
import java.util.*

class FilmFullFragment() : Fragment(R.layout.fragment_film_full) {

    companion object {
        private val MIN_LENGTH_VOTE_COUNT = 999
    }

    private var _binding: FragmentFilmFullBinding? = null
    private val binding get() = _binding!!


    private val viewModel by activityViewModels<SearchViewModel>()
    private lateinit var film: FilmUIFull

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            viewModel.getFullFilm((arguments as Bundle).getLong("filmId"))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFilmFullBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.fullFilm.observe(viewLifecycleOwner, object : Observer<FilmUIFull> {
            override fun onChanged(t: FilmUIFull?) {
                val film = t!!
                binding.title.text = "${film.nameOriginal} (${film.year})"
                binding.rutitle.text = film.nameRu ?: ""
                binding.shortDescription.text = film.description

                val textUrl = requireContext().resources.getString(R.string.url_for_film)
                val url = SpannableString("$textUrl ${film.webURL}")
                url.setSpan(
                    UnderlineSpan(),
                    textUrl.length + 1,
                    url.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                url.setSpan(object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        val webIntent = Intent(Intent.ACTION_VIEW)
                        webIntent.data = Uri.parse(url.toString().slice(textUrl.length + 1..url.length))
                        startActivity(webIntent)
                    }
                }, textUrl.length + 1, url.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                binding.filmUrl.text = url
                setRateColor(film.ratingImdb, binding.rating)
                binding.votesCount.text =
                    NumberFormat.getIntegerInstance(Locale.US).format(film.ratingImdbVoteCount)
                        .replace(",", " ")

                Glide.with(requireContext())
                    .load(film.posterURL)
                    .into(binding.image)
            }
        })


        super.onViewCreated(view, savedInstanceState)
    }


}