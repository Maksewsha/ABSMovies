package ru.maksewsha.absmovies.presentation.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryUI(
    val country: String?
): Parcelable{
    override fun toString(): String {
        return country ?: ""
    }
}