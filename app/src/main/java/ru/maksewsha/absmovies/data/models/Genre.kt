package ru.maksewsha.absmovies.data.models

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("genre")
    val genre: String?
)