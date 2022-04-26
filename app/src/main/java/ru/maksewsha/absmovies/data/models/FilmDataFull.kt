package ru.maksewsha.absmovies.data.models

import com.google.gson.annotations.SerializedName

data class FilmDataFull(
    @SerializedName("kinopoiskId")
    val kinopoiskID: Long,

    @SerializedName("imdbId")
    val imdbID: String,

    val nameRu: String,
    val nameEn: Any? = null,
    val nameOriginal: String,

    @SerializedName("posterUrl")
    val posterURL: String,

    @SerializedName("posterUrlPreview")
    val posterURLPreview: String,

    @SerializedName("coverUrl")
    val coverURL: String,

    @SerializedName("logoUrl")
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
    val ratingAwait: Any? = null,
    val ratingAwaitCount: Long,

    @SerializedName("ratingRfCritics")
    val ratingRFCritics: Long,

    @SerializedName("ratingRfCriticsVoteCount")
    val ratingRFCriticsVoteCount: Long,

    @SerializedName("webUrl")
    val webURL: String,

    val year: Long,
    val filmLength: Long,
    val slogan: String,
    val description: String,
    val shortDescription: String,
    val editorAnnotation: Any? = null,
    val isTicketsAvailable: Boolean,
    val productionStatus: Any? = null,
    val type: String,

    @SerializedName("ratingMpaa")
    val ratingMPAA: String,

    val ratingAgeLimits: String,
    val countries: List<Country>,
    val genres: List<Genre>,
    val startYear: Any? = null,
    val endYear: Any? = null,
    val serial: Boolean,
    val shortFilm: Boolean,
    val completed: Boolean,
    val hasImax: Boolean,
    val has3D: Boolean,
    val lastSync: String
)

data class Country(
    val country: String
)

data class Genre(
    val genre: String
)