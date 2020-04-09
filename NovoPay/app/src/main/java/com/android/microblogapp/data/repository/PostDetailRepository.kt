package com.android.microblogapp.data.repository

import com.android.microblogapp.data.model.Post
import com.android.microblogapp.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class PostDetailRepository @Inject constructor(
    private val networkService: NetworkService
) {

    fun fetchPostDetails(userId: Int): Single<Post>? {
        return networkService.doPostDetailsCall(
            userId
        ).map { it }
    }
}