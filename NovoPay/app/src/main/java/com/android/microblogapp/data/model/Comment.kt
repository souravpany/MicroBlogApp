package com.android.microblogapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Comment(

    @Expose
    @SerializedName("postId")
    val postID: Int,

    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("email")
    val email: String,

    @Expose
    @SerializedName("body")
    val body: String
)