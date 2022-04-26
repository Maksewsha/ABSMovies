package ru.maksewsha.absmovies.domain.usecases

import ru.maksewsha.absmovies.domain.repos.FilmsRepository

class GetByKeyWordCase(private val filmsRepository: FilmsRepository) {
    fun getByKeyWordCase(keyWords: String){
        return filmsRepository.getByKeyWord(keyWords)
    }
}