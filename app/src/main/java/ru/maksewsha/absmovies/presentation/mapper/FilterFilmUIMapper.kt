package ru.maksewsha.absmovies.presentation.mapper

import ru.maksewsha.absmovies.domain.models.FilmDomainFilters
import ru.maksewsha.absmovies.domain.utility.EntityMapper
import ru.maksewsha.absmovies.presentation.models.CountryUI
import ru.maksewsha.absmovies.presentation.models.FilmUIFilters
import ru.maksewsha.absmovies.presentation.models.FilmUIFiltersFull
import ru.maksewsha.absmovies.presentation.models.GenreUI

class FilterFilmUIMapper: EntityMapper<FilmDomainFilters, FilmUIFilters> {
    override fun mapFromEntity(entity: FilmUIFilters): FilmDomainFilters {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(objectToMap: FilmDomainFilters): FilmUIFilters = when (objectToMap){
        is FilmDomainFilters.Success -> FilmUIFilters.Success(
            objectToMap.data.map { ent ->
                FilmUIFiltersFull(
                    ent.kinopoiskID,
                    ent.imdbID,
                    ent.nameRu,
                    ent.nameEn,
                    ent.nameOriginal,
                    ent.countryDomains?.map {
                        CountryUI(it.country)
                    },
                    ent.genreDomains?.map{
                        GenreUI(it.genre)
                    },
                    ent.ratingKinopoisk,
                    ent.ratingImdb,
                    ent.year,
                    ent.type,
                    ent.posterURL,
                    ent.posterURLPreview
                )
            }
        )
        is FilmDomainFilters.Fail -> FilmUIFilters.Fail(objectToMap.errorMessage)
    }
}