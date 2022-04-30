package ru.maksewsha.absmovies.presentation.models

data class CountryUI(
    val country: String
){
    override fun toString(): String {
        return country
    }
}