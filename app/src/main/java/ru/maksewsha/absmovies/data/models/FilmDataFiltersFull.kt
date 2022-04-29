package ru.maksewsha.absmovies.data.models

import com.google.gson.annotations.SerializedName

data class FilmDataFiltersFull (
    @SerializedName("kinopoiskId")
    val kinopoiskID: Long?,

    @SerializedName("imdbId")
    val imdbID: String?,
    @SerializedName("nameRu")
    val nameRu: String?,
    @SerializedName("nameEn")
    val nameEn: Any? = null,
    @SerializedName("nameOriginal")
    val nameOriginal: String?,
    @SerializedName("countries")
    val countries: List<Country>?,
    @SerializedName("genres")
    val genres: List<Genre>?,
    @SerializedName("ratingKinopoisk")
    val ratingKinopoisk: Double?,
    @SerializedName("ratingImdb")
    val ratingImdb: Double?,
    @SerializedName("year")
    val year: Long?,
    @SerializedName("type")
    val type: String?,

    @SerializedName("posterUrl")
    val posterURL: String?,

    @SerializedName("posterUrlPreview")
    val posterURLPreview: String?
)