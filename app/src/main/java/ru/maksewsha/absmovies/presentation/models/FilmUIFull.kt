package ru.maksewsha.absmovies.presentation.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import ru.maksewsha.absmovies.domain.models.CountryDomain
import ru.maksewsha.absmovies.domain.models.GenreDomain

@Parcelize
data class FilmUIFull(
    val kinopoiskID: Long,
    val imdbID: String,

    val nameRu: String,
    val nameEn: String? = null,
    val nameOriginal: String,

    val posterURL: String,

    val posterURLPreview: String,

    val coverURL: String,

    val logoURL: String,

    val reviewsCount: Long,
    val ratingGoodReview: Double,
    val ratingGoodReviewVoteCount: Long,
    val ratingKinopoisk: Double,
    val ratingKinopoiskVoteCount: Long,
    val ratingImdb: Double,
    val ratingImdbVoteCount: Long,
    val ratingFilmCritics: Double,
    val ratingFilmCriticsVoteCount: Long,
    val ratingAwait: Double? = null,
    val ratingAwaitCount: Long,

    val ratingRFCritics: Long,

    val ratingRFCriticsVoteCount: Long,

    val webURL: String,

    val year: Long,
    val filmLength: Long,
    val slogan: String,
    val description: String,
    val shortDescription: String,
    val editorAnnotation: String? = null,
    val isTicketsAvailable: Boolean,
    val productionStatus: String? = null,
    val type: String,

    val ratingMPAA: String,

    val ratingAgeLimits: String,
    val countryDomains: List<CountryUI>,
    val genreDomains: List<GenreUI>,
    val startYear: Int? = null,
    val endYear: Int? = null,
    val serial: Boolean,
    val shortFilm: Boolean,
    val completed: Boolean,
    val hasImax: Boolean,
    val has3D: Boolean,
    val lastSync: String
): Parcelable