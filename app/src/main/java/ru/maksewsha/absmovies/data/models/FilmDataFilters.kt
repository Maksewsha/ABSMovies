package ru.maksewsha.absmovies.data.models

sealed class FilmDataFilters {
    class Success(val data: List<FilmDataFiltersFull>): FilmDataFilters()
    class Fail(val errorMessage: String): FilmDataFilters()
}