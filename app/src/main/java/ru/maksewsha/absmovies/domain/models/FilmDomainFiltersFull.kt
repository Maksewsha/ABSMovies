package ru.maksewsha.absmovies.domain.models


data class FilmDomainFiltersFull (
    val kinopoiskID: Long,

    val imdbID: String?,

    val nameRu: String?,
    val nameEn: String?,
    val nameOriginal: String?,
    val countryDomains: List<CountryDomain>?,
    val genreDomains: List<GenreDomain>?,
    val ratingKinopoisk: Double?,
    val ratingImdb: Double?,
    val year: Long?,
    val type: String?,

    val posterURL: String?,

    val posterURLPreview: String?
)