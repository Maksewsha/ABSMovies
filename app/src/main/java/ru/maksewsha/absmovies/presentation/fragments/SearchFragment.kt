package ru.maksewsha.absmovies.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import ru.maksewsha.absmovies.R
import ru.maksewsha.absmovies.databinding.FragmentFilmsSearchBinding
import ru.maksewsha.absmovies.presentation.models.FilmUIFiltersFull
import ru.maksewsha.absmovies.presentation.viewmodels.SearchViewModel

class SearchFragment: Fragment(R.layout.fragment_films_search) {
    private var _binding: FragmentFilmsSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<SearchViewModel>()

    private lateinit var keyWordEditText: EditText
    private lateinit var searchButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFilmsSearchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        keyWordEditText = binding.keyWordEditText
        searchButton = binding.searchButton

        searchButton.setOnClickListener {
            viewModel.getFilmsByFilter(keyWordEditText.text.toString())
            Log.d("TAG", "Button clicked")
        }

        viewModel.errorMessage.observe(viewLifecycleOwner, object: Observer<String>{
            override fun onChanged(t: String?) {
                Snackbar.make(view, "$t", Snackbar.LENGTH_SHORT).show()
                Log.d("TAG", t.toString())
            }
        })

        viewModel.filmsFilters.observe(viewLifecycleOwner, object: Observer<List<FilmUIFiltersFull>>{
            override fun onChanged(t: List<FilmUIFiltersFull>?) {
                Log.d("TAG", t!!.get(0).nameRu)
            }

        })

        super.onViewCreated(view, savedInstanceState)
    }
}