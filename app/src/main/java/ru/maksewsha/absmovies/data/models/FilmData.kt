package ru.maksewsha.absmovies.data.models

sealed class FilmData {
    class Success(val data: FilmDataFull): FilmData()
    class Fail(val errorMessage: String): FilmData()
}