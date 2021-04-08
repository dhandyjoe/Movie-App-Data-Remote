package com.example.movieappapi.data.remote

import android.os.Parcel
import android.os.Parcelable


data class DataMovie (
    val id: String?,
    val overview: String?,
    val poster_path: String?,
    val original_title: String?
): Parcelable{
    val baseUrlImage get() = "https://image.tmdb.org/t/p/w500"

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(overview)
        parcel.writeString(poster_path)
        parcel.writeString(original_title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataMovie> {
        override fun createFromParcel(parcel: Parcel): DataMovie {
            return DataMovie(parcel)
        }

        override fun newArray(size: Int): Array<DataMovie?> {
            return arrayOfNulls(size)
        }
    }
}