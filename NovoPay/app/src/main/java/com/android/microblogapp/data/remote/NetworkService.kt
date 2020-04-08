package com.android.microblogapp.data.remote

import com.android.microblogapp.data.model.Post
import com.android.microblogapp.data.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton


@Singleton
interface NetworkService {

    @GET(Endpoints.USER_LIST)
    fun doUserListCall(
    ): Single<List<User>>


    @GET(Endpoints.USER_LIST + "/{userId}")
    fun doUserDetailsCall(
        @Path(
            value = "userId",
            encoded = true
        ) userId: Int?
    ): Single<User?>?


    @GET(Endpoints.POST_LIST)
    fun doPostListCall(
        @Query("userId") userId: Int
    ): Single<List<Post>>


}
