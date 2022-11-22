package com.example.proyectologin

import android.os.Parcel
import android.os.Parcelable

data class Users(val nameUser:String,val passUser:String) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString().toString()
        )



        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(nameUser)
            parcel.writeString(passUser)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Users> {
            override fun createFromParcel(parcel: Parcel): Users {
                return Users(parcel)
            }

            override fun newArray(size: Int): Array<Users?> {
                return arrayOfNulls(size)
            }
        }
    }


