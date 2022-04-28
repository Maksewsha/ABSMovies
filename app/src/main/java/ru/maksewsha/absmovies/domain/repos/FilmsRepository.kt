package ru.maksewsha.absmovies.domain.repos

import ru.maksewsha.absmovies.domain.models.FilmDomain
import ru.maksewsha.absmovies.domain.models.FilmDomainFilters

interface FilmsRepository {
    fun getByFilters(keyWord: String): FilmDomainFilters
    fun getByKinopoiskID(id: Int): FilmDomain
}