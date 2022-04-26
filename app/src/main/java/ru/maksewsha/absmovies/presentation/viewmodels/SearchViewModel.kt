package ru.maksewsha.absmovies.presentation.viewmodels

import androidx.lifecycle.ViewModel
import ru.maksewsha.absmovies.domain.usecases.GetByKeyWordCase

class SearchViewModel(private val getByKeyWordCase: GetByKeyWordCase): ViewModel() {

    fun search(keyWords: String){

    }
}