package com.example.proyectologin

import android.os.Parcel
import android.os.Parcelable


data class Usuario(var password:String="") : Persona(), Parcelable {


    constructor(parcel: Parcel) : this() {
        password = parcel.readString().toString()
        nombre=parcel.readString().toString()
        apellido=parcel.readString().toString()
        documento=parcel.readString().toString()
        direccion=parcel.readString().toString()
        mail=parcel.readString().toString()

    }



    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(password)
        parcel.writeString(nombre)
        parcel.writeString(apellido)
        parcel.writeString(documento)
        parcel.writeString(direccion)
        parcel.writeString(mail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }

}

