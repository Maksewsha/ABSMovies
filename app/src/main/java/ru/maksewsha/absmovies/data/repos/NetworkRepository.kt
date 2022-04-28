package ru.maksewsha.absmovies.data.repos

import ru.maksewsha.absmovies.data.mappers.FilterFilmDataMapper
import ru.maksewsha.absmovies.data.mappers.FullFilmDataMapper
import ru.maksewsha.absmovies.data.models.FilmData
import ru.maksewsha.absmovies.data.models.FilmDataFilters
import ru.maksewsha.absmovies.data.models.FilmDataFiltersFull
import ru.maksewsha.absmovies.data.models.FilmDataFull
import ru.maksewsha.absmovies.data.network.RetrofitService
import ru.maksewsha.absmovies.domain.models.FilmDomain
import ru.maksewsha.absmovies.domain.models.FilmDomainFilters
import ru.maksewsha.absmovies.domain.repos.FilmsRepository

class NetworkRepository constructor(private val retrofitService: RetrofitService) : FilmsRepository{
    private val fullFilmMapper = FullFilmDataMapper()
    private val filterMapper = FilterFilmDataMapper()
    override fun getByFilters(keyWord: String): FilmDomainFilters {
        val response = retrofitService.getByKeyWord(keyWord)
        val result = response.execute()
        return if (result.isSuccessful){
            filterMapper.mapFromEntity(FilmDataFilters.Success(result.body() as List<FilmDataFiltersFull>))
        } else {
            filterMapper.mapFromEntity(FilmDataFilters.Fail(result.message()))
        }
    }

    override fun getByKinopoiskID(id: Int): FilmDomain {
        val response = retrofitService.getByKinopoiskId(id)
        val result = response.execute()
        return if (result.isSuccessful){
            fullFilmMapper.mapFromEntity(FilmData.Success(result.body() as FilmDataFull))
        } else {
            fullFilmMapper.mapFromEntity(FilmData.Fail(result.message()))
        }
    }


}