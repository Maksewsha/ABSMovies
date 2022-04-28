package ru.maksewsha.absmovies.data.models

import com.google.gson.annotations.SerializedName

data class FilmList(
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalPages")
    val totalPages: Int,
    @SerializedName("items")
    val items: List<FilmDataFiltersFull>?
)