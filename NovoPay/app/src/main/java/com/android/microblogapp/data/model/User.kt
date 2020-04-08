package com.android.microblogapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(

    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("phone")
    val phone: String,

    @Expose
    @SerializedName("username")
    val username: String,

    @Expose
    @SerializedName("website")
    val website: String?,

    @Expose
    @SerializedName("email")
    val email: String?,

    @Expose
    @SerializedName("company")
    val company: Company?,

    @Expose
    @SerializedName("address")
    val address: Address?
)