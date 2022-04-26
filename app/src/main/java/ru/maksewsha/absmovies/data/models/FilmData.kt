package ru.maksewsha.absmovies.data.models

sealed class FilmData {
    class Success(val data: List<FilmDataFull>): FilmData()
    class Fail(val errorMessage: String): FilmData()
}