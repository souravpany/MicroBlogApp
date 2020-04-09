package com.android.microblogapp.data.repository

import com.android.microblogapp.data.model.Comment
import com.android.microblogapp.data.model.Post
import com.android.microblogapp.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class CommentDetailRepository @Inject constructor(
    private val networkService: NetworkService
) {

    fun fetchCommentList(postId: Int): Single<List<Comment>>? {
        return networkService.doCommentDetailsCall(
            postId
        ).map { it }
    }
}