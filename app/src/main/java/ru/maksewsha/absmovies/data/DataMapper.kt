package ru.maksewsha.absmovies.data

import ru.maksewsha.absmovies.data.models.FilmData
import ru.maksewsha.absmovies.domain.models.Country
import ru.maksewsha.absmovies.domain.models.FilmDomain
import ru.maksewsha.absmovies.domain.models.FilmDomainFull
import ru.maksewsha.absmovies.domain.models.Genre
import ru.maksewsha.absmovies.domain.utility.EntityMapper

class DataMapper : EntityMapper<FilmDomain, FilmData> {
    override fun mapFromEntity(entity: FilmData): FilmDomain = when(entity){
        is FilmData.Success -> FilmDomain.Success(
            entity.data.map { ent ->
                FilmDomainFull(
                    ent.kinopoiskID,
                    ent.imdbID,
                    ent.nameRu,
                    ent.nameEn,
                    ent.nameOriginal,
                    ent.posterURL,
                    ent.posterURLPreview,
                    ent.coverURL,
                    ent.logoURL,
                    ent.reviewsCount,
                    ent.ratingGoodReview,
                    ent.ratingGoodReviewVoteCount,
                    ent.ratingKinopoisk,
                    ent.ratingKinopoiskVoteCount,
                    ent.ratingImdb,
                    ent.ratingImdbVoteCount,
                    ent.ratingFilmCritics,
                    ent.ratingFilmCriticsVoteCount,
                    ent.ratingAwait,
                    ent.ratingAwaitCount,
                    ent.ratingRFCritics,
                    ent.ratingRFCriticsVoteCount,
                    ent.webURL,
                    ent.year,
                    ent.filmLength,
                    ent.slogan,
                    ent.description,
                    ent.shortDescription,
                    ent.editorAnnotation,
                    ent.isTicketsAvailable,
                    ent.productionStatus,
                    ent.type,
                    ent.ratingMPAA,
                    ent.ratingAgeLimits,
                    ent.countries.map {
                                      Country(it.country)
                    },
                    ent.genres.map {
                                   Genre(it.genre)
                    },
                    ent.startYear,
                    ent.endYear,
                    ent.serial,
                    ent.shortFilm,
                    ent.completed,
                    ent.hasImax,
                    ent.has3D,
                    ent.lastSync
                )
            }
        )
        is FilmData.Fail -> FilmDomain.Fail(entity.errorMessage)
    }

    override fun mapToEntity(objectToMap: FilmDomain): FilmData {
        TODO("Not yet implemented")
    }

}