package com.android.microblogapp.data.repository

import com.android.microblogapp.data.model.Post
import com.android.microblogapp.data.model.User
import com.android.microblogapp.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class UserDetailsRepository @Inject constructor(
    private val networkService: NetworkService
) {

    fun fetchUserDetails(userId: Int): Single<User>? {
        return networkService.doUserDetailsCall(
            userId
        )!!.map { it }
    }
}