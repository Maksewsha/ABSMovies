package ru.maksewsha.absmovies.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
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
        job = CoroutineScope(Dispatchers.IO).launch {
            val response =
                filterFilmUIMapper.mapToEntity(getByKeyWordCase.getByKeyWordCase(keyWord))
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

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}