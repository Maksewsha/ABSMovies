package ru.maksewsha.absmovies.data.models

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("genre")
    val country: String
)