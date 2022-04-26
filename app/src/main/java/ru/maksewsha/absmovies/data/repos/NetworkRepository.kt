package ru.maksewsha.absmovies.data.repos

import ru.maksewsha.absmovies.data.DataMapper
import ru.maksewsha.absmovies.data.models.FilmData
import ru.maksewsha.absmovies.data.models.FilmDataFilters
import ru.maksewsha.absmovies.data.network.RetrofitService
import ru.maksewsha.absmovies.domain.repos.FilmsRepository

class NetworkRepository constructor(private val retrofitService: RetrofitService) : FilmsRepository{
    private val dataMapper = DataMapper()
    override fun getByFilters(keyWord: String) {
        val response = retrofitService.getByKeyWord(keyWord)
        val result = response.execute()
        //TODO
    }

    override fun getByKinopoiskId(id: Int) {
        TODO("Not yet implemented")
    }

}