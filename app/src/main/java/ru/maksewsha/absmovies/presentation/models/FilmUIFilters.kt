package ru.maksewsha.absmovies.presentation.models

sealed class FilmUIFilters {
    class Success(val data: List<FilmUIFiltersFull>): FilmUIFilters()
    class Fail(val errorMessage: String): FilmUIFilters()
}