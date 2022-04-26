package ru.maksewsha.absmovies.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.maksewsha.absmovies.R
import ru.maksewsha.absmovies.databinding.FragmentFilmsSearchBinding
import ru.maksewsha.absmovies.presentation.viewmodels.SearchViewModel

class SearchFragment: Fragment(R.layout.fragment_films_search) {
    private var _binding: FragmentFilmsSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SearchViewModel

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
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        searchButton.setOnClickListener {
            viewModel.search(keyWordEditText.text.toString())
        }

        super.onViewCreated(view, savedInstanceState)
    }
}