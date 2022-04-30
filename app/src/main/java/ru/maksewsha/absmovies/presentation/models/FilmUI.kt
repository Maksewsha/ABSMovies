package ru.maksewsha.absmovies.presentation.models

sealed class FilmUI {
    class Success(val data: FilmUIFull): FilmUI()
    class Fail(val errorMessage: String): FilmUI()
}