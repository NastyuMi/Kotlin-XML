package com.example.applicationwith3activity

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter() : RecyclerView.Adapter<UserAdapter.UserViewHolder>(), Parcelable {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    constructor(parcel: Parcel) : this() {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<UserAdapter> {
        override fun createFromParcel(parcel: Parcel): UserAdapter {
            return UserAdapter(parcel)
        }

        override fun newArray(size: Int): Array<UserAdapter?> {
            return arrayOfNulls(size)
        }
    }

}