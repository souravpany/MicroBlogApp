package com.android.microblogapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Company(

    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("catchPhrase")
    val catchPhrase: String,

    @Expose
    @SerializedName("bs")
    val bs: String

)