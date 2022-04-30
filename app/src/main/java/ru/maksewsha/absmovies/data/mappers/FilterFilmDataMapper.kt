package ru.maksewsha.absmovies.data.mappers

import android.util.Log
import ru.maksewsha.absmovies.data.models.FilmDataFilters
import ru.maksewsha.absmovies.domain.models.CountryDomain
import ru.maksewsha.absmovies.domain.models.FilmDomainFilters
import ru.maksewsha.absmovies.domain.models.FilmDomainFiltersFull
import ru.maksewsha.absmovies.domain.models.GenreDomain
import ru.maksewsha.absmovies.domain.utility.EntityMapper

class FilterFilmDataMapper: EntityMapper<FilmDomainFilters, FilmDataFilters> {
    override fun mapFromEntity(entity: FilmDataFilters): FilmDomainFilters = when(entity){
        is FilmDataFilters.Success -> FilmDomainFilters.Success(
            entity.data.map { ent ->
                FilmDomainFiltersFull(
                    ent.kinopoiskID,
                    ent.imdbID,
                    ent.nameRu,
                    ent.nameEn,
                    ent.nameOriginal,
                    ent.countries.map {
                        CountryDomain(it.country)
                    },
                    ent.genres.map{
                        GenreDomain(it.genre)
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
        is FilmDataFilters.Fail -> FilmDomainFilters.Fail(
            entity.errorMessage
        )
    }

    override fun mapToEntity(objectToMap: FilmDomainFilters): FilmDataFilters {
        TODO("Not yet implemented")
    }

}