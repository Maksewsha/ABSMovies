package ru.maksewsha.absmovies.presentation.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreUI(
    val genre: String?
): Parcelable{
    override fun toString(): String {
        return genre ?: ""
    }
}