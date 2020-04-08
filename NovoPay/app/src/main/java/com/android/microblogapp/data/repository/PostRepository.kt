package com.android.microblogapp.data.repository

import com.android.microblogapp.data.model.Post
import com.android.microblogapp.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val networkService: NetworkService
) {

    fun fetchPostList(userId: Int): Single<List<Post>>? {
        return networkService.doPostListCall(
            userId
        ).map { it }
    }
}