package ru.maksewsha.absmovies.domain.usecases

import ru.maksewsha.absmovies.domain.models.FilmDomainFilters
import ru.maksewsha.absmovies.domain.repos.FilmsRepository

class GetByKeyWordCase(private val filmsRepository: FilmsRepository) {
    suspend fun getByKeyWordCase(keyWords: String): FilmDomainFilters{
        return filmsRepository.getByFilters(keyWords)
    }
}