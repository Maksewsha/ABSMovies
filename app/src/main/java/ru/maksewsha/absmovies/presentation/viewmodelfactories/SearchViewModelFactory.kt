package ru.maksewsha.absmovies.presentation.viewmodelfactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.maksewsha.absmovies.data.network.RetrofitService
import ru.maksewsha.absmovies.data.repos.NetworkRepository
import ru.maksewsha.absmovies.domain.usecases.GetByKeyWordCase
import ru.maksewsha.absmovies.domain.usecases.GetByKinopoiskIDCase
import ru.maksewsha.absmovies.presentation.viewmodels.SearchViewModel

class SearchViewModelFactory: ViewModelProvider.Factory {

    private val retrofitService by lazy (LazyThreadSafetyMode.NONE){
        RetrofitService.getInstance()
    }

    private val networkRepository by lazy (LazyThreadSafetyMode.NONE){
        NetworkRepository(retrofitService)
    }

    private val getByKeyWordCase by lazy (LazyThreadSafetyMode.NONE){
        GetByKeyWordCase(networkRepository)
    }

    private val getByKinopoiskIDCase by lazy(LazyThreadSafetyMode.NONE) {
        GetByKinopoiskIDCase(networkRepository)
    }


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(getByKeyWordCase, getByKinopoiskIDCase) as T
    }
}