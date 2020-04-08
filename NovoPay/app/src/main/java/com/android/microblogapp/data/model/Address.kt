package com.android.microblogapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Address(

    @Expose
    @SerializedName("city")
    val city: String,

    @Expose
    @SerializedName("street")
    val street: String,

    @Expose
    @SerializedName("suite")
    val suite: String,

    @Expose
    @SerializedName("zipcode")
    val zipcode: String,

    @Expose
    @SerializedName("geo")
    val geo: Geo


)