package ru.maksewsha.absmovies.domain.models

sealed class FilmDomain {
    class Success(val data: List<FilmDomainFull>): FilmDomain()
    class Fail(val errorMessage: String): FilmDomain()
}