package ru.maksewsha.absmovies.presentation.models

data class FilmUIFiltersFull(
    val kinopoiskID: Long?,

    val imdbID: String?,

    val nameRu: String?,
    val nameEn: Any? = null,
    val nameOriginal: String?,
    val countryDomains: List<CountryUI>,
    val genreDomains: List<GenreUI>,
    val ratingKinopoisk: Double?,
    val ratingImdb: Double?,
    val year: Long?,
    val type: String?,

    val posterURL: String?,

    val posterURLPreview: String?
)