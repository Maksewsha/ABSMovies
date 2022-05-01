package ru.maksewsha.absmovies.presentation.mapper

import ru.maksewsha.absmovies.domain.models.FilmDomain
import ru.maksewsha.absmovies.domain.utility.EntityMapper
import ru.maksewsha.absmovies.presentation.models.CountryUI
import ru.maksewsha.absmovies.presentation.models.FilmUI
import ru.maksewsha.absmovies.presentation.models.FilmUIFull
import ru.maksewsha.absmovies.presentation.models.GenreUI

class FullFilmUIMapper: EntityMapper<FilmDomain, FilmUI> {
    override fun mapFromEntity(entity: FilmUI): FilmDomain {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(objectToMap: FilmDomain): FilmUI = when(objectToMap){
        is FilmDomain.Success -> FilmUI.Success(FilmUIFull(
            objectToMap.data.kinopoiskID,
            objectToMap.data.imdbID,
            objectToMap.data.nameRu,
            objectToMap.data.nameEn,
            objectToMap.data.nameOriginal,
            objectToMap.data.posterURL,
            objectToMap.data.posterURLPreview,
            objectToMap.data.coverURL,
            objectToMap.data.logoURL,
            objectToMap.data.reviewsCount,
            objectToMap.data.ratingGoodReview,
            objectToMap.data.ratingGoodReviewVoteCount,
            objectToMap.data.ratingKinopoisk,
            objectToMap.data.ratingKinopoiskVoteCount,
            objectToMap.data.ratingImdb,
            objectToMap.data.ratingImdbVoteCount,
            objectToMap.data.ratingFilmCritics,
            objectToMap.data.ratingFilmCriticsVoteCount,
            objectToMap.data.ratingAwait,
            objectToMap.data.ratingAwaitCount,
            objectToMap.data.ratingRFCritics,
            objectToMap.data.ratingRFCriticsVoteCount,
            objectToMap.data.webURL,
            objectToMap.data.year,
            objectToMap.data.filmLength,
            objectToMap.data.slogan,
            objectToMap.data.description,
            objectToMap.data.shortDescription,
            objectToMap.data.editorAnnotation,
            objectToMap.data.isTicketsAvailable,
            objectToMap.data.productionStatus,
            objectToMap.data.type,
            objectToMap.data.ratingMPAA,
            objectToMap.data.ratingAgeLimits,
            objectToMap.data.countryDomains.map{
                CountryUI(it.country)
            },
            objectToMap.data.genreDomains.map{
                GenreUI(it.genre)
            },
            objectToMap.data.startYear,
            objectToMap.data.endYear,
            objectToMap.data.serial,
            objectToMap.data.shortFilm,
            objectToMap.data.completed,
            objectToMap.data.hasImax,
            objectToMap.data.has3D,
            objectToMap.data.lastSync
        ))
        is FilmDomain.Fail -> FilmUI.Fail(objectToMap.errorMessage)
    }
}