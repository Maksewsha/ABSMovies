package ru.maksewsha.absmovies.data.models

import com.google.gson.annotations.SerializedName

data class FilmDataFiltersFull (
    @SerializedName("kinopoiskId")
    val kinopoiskID: Long,

    @SerializedName("imdbId")
    val imdbID: String,

    val nameRu: String,
    val nameEn: Any? = null,
    val nameOriginal: String,
    val countries: List<Country>,
    val genres: List<Genre>,
    val ratingKinopoisk: Double,
    val ratingImdb: Double,
    val year: Long,
    val type: String,

    @SerializedName("posterUrl")
    val posterURL: String,

    @SerializedName("posterUrlPreview")
    val posterURLPreview: String
)