package com.android.microblogapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Post(

    @Expose
    @SerializedName("userId")
    val userId: Int,

    @Expose
    @SerializedName("title")
    val title: String,

    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("body")
    val body: String
)