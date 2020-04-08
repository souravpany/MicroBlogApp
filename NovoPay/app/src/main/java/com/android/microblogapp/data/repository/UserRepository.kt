package com.android.microblogapp.data.repository

import com.android.microblogapp.data.model.User
import com.android.microblogapp.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val networkService: NetworkService
) {

    fun fetchUserList(): Single<List<User>>? {
        return networkService.doUserListCall(
        ).map { it }
    }
}