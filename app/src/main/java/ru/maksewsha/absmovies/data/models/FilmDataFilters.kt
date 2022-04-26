package ru.maksewsha.absmovies.data.models

import com.google.gson.annotations.SerializedName

data class FilmDataFilters(
    @SerializedName("kinopoiskId")
    val kinopoiskId: Int
)