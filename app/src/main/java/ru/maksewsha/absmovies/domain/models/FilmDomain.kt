package ru.maksewsha.absmovies.domain.models

sealed class FilmDomain {
    class Success(val data: FilmDomainFull): FilmDomain()
    class Fail(val errorMessage: String): FilmDomain()
}