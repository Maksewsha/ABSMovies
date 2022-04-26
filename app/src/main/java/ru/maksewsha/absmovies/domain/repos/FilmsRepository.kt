package ru.maksewsha.absmovies.domain.repos

interface FilmsRepository {
    fun getByFilters(keyWord: String)
    fun getByKinopoiskId(id: Int)
}