package com.android.microblogapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Geo(

    @Expose
    @SerializedName("lat")
    val lat: String,

    @Expose
    @SerializedName("lng")
    val lng: String
)