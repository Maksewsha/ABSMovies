package ru.maksewsha.absmovies.domain.repos

import ru.maksewsha.absmovies.domain.models.FilmDomain
import ru.maksewsha.absmovies.domain.models.FilmDomainFilters

interface FilmsRepository {
    suspend fun getByFilters(keyWord: String): FilmDomainFilters
    suspend fun getByKinopoiskID(id: Long): FilmDomain
}