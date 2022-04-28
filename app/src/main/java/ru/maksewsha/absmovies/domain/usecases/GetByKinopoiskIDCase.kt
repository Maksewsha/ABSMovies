package ru.maksewsha.absmovies.domain.usecases

import ru.maksewsha.absmovies.domain.models.FilmDomain
import ru.maksewsha.absmovies.domain.repos.FilmsRepository

class GetByKinopoiskIDCase(private val filmsRepository: FilmsRepository) {
    fun getByKinopoiskIDCase(id: Int): FilmDomain{
        return filmsRepository.getByKinopoiskID(id)
    }
}