package com.desafio.githubchallenge.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

data class Repositorio(
    var autor : String?,
    var nomeRepos : String?,
    var forks : String?,
    var stars : String?,
    @DrawableRes
    var icone : Int
) :Parcelable {

    constructor(parcel: Parcel) : this(
        autor = parcel.readString(),
        nomeRepos = parcel.readString(),
        forks = parcel.readString(),
        stars = parcel.readString(),
        icone = parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(autor)
        parcel.writeString(nomeRepos)
        parcel.writeString(forks)
        parcel.writeString(stars)
        parcel.writeInt(icone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Repositorio> {
        override fun createFromParcel(parcel: Parcel): Repositorio {
            return Repositorio(parcel)
        }

        override fun newArray(size: Int): Array<Repositorio?> {
            return arrayOfNulls(size)
        }
    }
}
