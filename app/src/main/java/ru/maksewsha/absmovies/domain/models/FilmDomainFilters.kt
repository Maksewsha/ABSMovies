package ru.maksewsha.absmovies.domain.models

sealed class FilmDomainFilters {

    class Success(val data: List<FilmDomainFiltersFull>): FilmDomainFilters()
    class Fail(val errorMessage: String): FilmDomainFilters()
}