package ru.maksewsha.absmovies.domain.repos

interface FilmsRepository {
    fun getByKeyWord(keyWord: String)
}