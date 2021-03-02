package com.example.puppyadoption

import android.os.Parcel
import android.os.Parcelable

class Puppy() : Parcelable{
    var type:String = ""
    var name:String = ""
    var age:String = ""
    var weight:String = ""
    var address:String = ""
    var photo:Int = 0

    constructor(parcel: Parcel) : this() {
        type = parcel.readString().toString()
        name = parcel.readString().toString()
        age = parcel.readString().toString()
        weight = parcel.readString().toString()
        address = parcel.readString().toString()
        photo = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(name)
        parcel.writeString(age)
        parcel.writeString(weight)
        parcel.writeString(address)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Puppy> {
        override fun createFromParcel(parcel: Parcel): Puppy {
            return Puppy(parcel)
        }

        override fun newArray(size: Int): Array<Puppy?> {
            return arrayOfNulls(size)
        }

        fun buildList(): ArrayList<Puppy> {
            val puppiesList = ArrayList<Puppy>()
            var p = Puppy()
            p.type = "Boxer"
            p.name = "Boxy"
            p.age = "4 months"
            p.weight = "30kg"
            p.address = "3921  Rinehart Road, UNIOPOLIS"
            p.photo = R.drawable.a1
            puppiesList.add(p)

            p = Puppy()
            p.type = "Labrador Retriever"
            p.name = "Labi"
            p.age = "4 months"
            p.weight = "30kg"
            p.address = "3921  Rinehart Road, UNIOPOLIS"
            p.photo = R.drawable.a2
            puppiesList.add(p)

            p = Puppy()
            p.type = "German Shepherd"
            p.name = "Germi"
            p.age = "4 months"
            p.weight = "30kg"
            p.address = "3921  Rinehart Road, UNIOPOLIS"
            p.photo = R.drawable.a3
            puppiesList.add(p)

            p = Puppy()
            p.type = "Golden Retriever"
            p.name = "Goldi"
            p.age = "4 months"
            p.weight = "30kg"
            p.address = "3921  Rinehart Road, UNIOPOLIS"
            p.photo = R.drawable.a4
            puppiesList.add(p)

            p = Puppy()
            p.type = "French Bulldo"
            p.name = "Franki"
            p.age = "4 months"
            p.weight = "30kg"
            p.address = "3921  Rinehart Road, UNIOPOLIS"
            p.photo = R.drawable.a5
            puppiesList.add(p)

            p = Puppy()
            p.type = "Bulldog"
            p.name = "Bill"
            p.age = "4 months"
            p.weight = "30kg"
            p.address = "3921  Rinehart Road, UNIOPOLIS"
            p.photo = R.drawable.a6
            puppiesList.add(p)

            p = Puppy()
            p.type = "Dalmatia"
            p.name = "Doli"
            p.age = "4 months"
            p.weight = "30kg"
            p.address = "3921  Rinehart Road, UNIOPOLIS"
            p.photo = R.drawable.a7
            puppiesList.add(p)

            p = Puppy()
            p.type = "Beagle Retriever"
            p.name = "BIGI"
            p.age = "4 months"
            p.weight = "30kg"
            p.address = "3921  Rinehart Road, UNIOPOLIS"
            p.photo = R.drawable.a8
            puppiesList.add(p)
            return puppiesList
        }
    }



}