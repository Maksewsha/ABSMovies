package ru.maksewsha.absmovies.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import ru.maksewsha.absmovies.R
import ru.maksewsha.absmovies.databinding.FragmentFilmFullBinding
import ru.maksewsha.absmovies.presentation.models.FilmUIFull
import ru.maksewsha.absmovies.presentation.viewmodels.SearchViewModel

class FilmFullFragment(): Fragment(R.layout.fragment_film_full) {

    private var _binding: FragmentFilmFullBinding? = null
    private val binding get() = _binding!!


    private val viewModel by activityViewModels<SearchViewModel>()
    private lateinit var film: FilmUIFull

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null){
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.fullFilm.observe(viewLifecycleOwner, object: Observer<FilmUIFull>{
            override fun onChanged(t: FilmUIFull?) {
                binding.title.text = t!!.nameOriginal
            }
        })


        super.onViewCreated(view, savedInstanceState)
    }


}