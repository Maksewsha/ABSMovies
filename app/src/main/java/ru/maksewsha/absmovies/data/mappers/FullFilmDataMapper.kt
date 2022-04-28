package ru.maksewsha.absmovies.data.mappers

import ru.maksewsha.absmovies.data.models.FilmData
import ru.maksewsha.absmovies.domain.models.*
import ru.maksewsha.absmovies.domain.utility.EntityMapper

class FullFilmDataMapper : EntityMapper<FilmDomain, FilmData> {
    override fun mapFromEntity(entity: FilmData): FilmDomain = when(entity){
        is FilmData.Success -> FilmDomain.Success(
                FilmDomainFull(
                    entity.data.kinopoiskID,
                    entity.data.imdbID,
                    entity.data.nameRu,
                    entity.data.nameEn,
                    entity.data.nameOriginal,
                    entity.data.posterURL,
                    entity.data.posterURLPreview,
                    entity.data.coverURL,
                    entity.data.logoURL,
                    entity.data.reviewsCount,
                    entity.data.ratingGoodReview,
                    entity.data.ratingGoodReviewVoteCount,
                    entity.data.ratingKinopoisk,
                    entity.data.ratingKinopoiskVoteCount,
                    entity.data.ratingImdb,
                    entity.data.ratingImdbVoteCount,
                    entity.data.ratingFilmCritics,
                    entity.data.ratingFilmCriticsVoteCount,
                    entity.data.ratingAwait,
                    entity.data.ratingAwaitCount,
                    entity.data.ratingRFCritics,
                    entity.data.ratingRFCriticsVoteCount,
                    entity.data.webURL,
                    entity.data.year,
                    entity.data.filmLength,
                    entity.data.slogan,
                    entity.data.description,
                    entity.data.shortDescription,
                    entity.data.editorAnnotation,
                    entity.data.isTicketsAvailable,
                    entity.data.productionStatus,
                    entity.data.type,
                    entity.data.ratingMPAA,
                    entity.data.ratingAgeLimits,
                    entity.data.countries.map {
                                      CountryDomain(it.country)
                    },
                    entity.data.genres.map {
                                   GenreDomain(it.genre)
                    },
                    entity.data.startYear,
                    entity.data.endYear,
                    entity.data.serial,
                    entity.data.shortFilm,
                    entity.data.completed,
                    entity.data.hasImax,
                    entity.data.has3D,
                    entity.data.lastSync)
                )
        is FilmData.Fail -> FilmDomain.Fail(entity.errorMessage)
    }

    override fun mapToEntity(objectToMap: FilmDomain): FilmData {
        TODO("Not yet implemented")
    }

}