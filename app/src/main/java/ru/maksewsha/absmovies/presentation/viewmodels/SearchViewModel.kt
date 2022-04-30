package ru.maksewsha.absmovies.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.maksewsha.absmovies.domain.usecases.GetByKeyWordCase
import ru.maksewsha.absmovies.presentation.mapper.FilterFilmUIMapper
import ru.maksewsha.absmovies.presentation.models.FilmUIFilters
import ru.maksewsha.absmovies.presentation.models.FilmUIFiltersFull

class SearchViewModel(private val getByKeyWordCase: GetByKeyWordCase) : ViewModel() {
    private val _filmsFilters = MutableLiveData<List<FilmUIFiltersFull>>()
    val filmsFilters = _filmsFilters as LiveData<List<FilmUIFiltersFull>>

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage = _errorMessage as LiveData<String>

    private var job: Job? = null

    private val filterFilmUIMapper = FilterFilmUIMapper()

    fun getFilmsByFilter(keyWord: String) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            val response =
                filterFilmUIMapper.mapToEntity(
                    getByKeyWordCase.getByKeyWordCase(
                        keyWord
                    )
                )
            when (response) {
                is FilmUIFilters.Success -> {
                    _filmsFilters.postValue(response.data)
                }
                is FilmUIFilters.Fail -> {
                    _errorMessage.postValue(response.errorMessage)
                }
            }
        }
    }

    fun getFullFilm(id: Int){
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            //TODO
        }
    }
}