package com.android.microblogapp.ui.userprofile

import androidx.lifecycle.MutableLiveData
import com.android.microblogapp.data.model.Post
import com.android.microblogapp.data.repository.PostRepository
import com.android.microblogapp.data.repository.UserDetailsRepository
import com.android.microblogapp.ui.base.BaseViewModel
import com.android.microblogapp.utils.common.Resource
import com.android.microblogapp.utils.network.NetworkHelper
import com.android.microblogapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class UserProfileViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val arrayListPost: ArrayList<Post>,
    private val userDetailsRepository: UserDetailsRepository,
    private val postRepository: PostRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val userIdValue: MutableLiveData<Int> = MutableLiveData()
    val userName: MutableLiveData<String> = MutableLiveData()
    val userEmail: MutableLiveData<String> = MutableLiveData()
    val userId: MutableLiveData<Int> = MutableLiveData()

    val userProfilePbLoading: MutableLiveData<Boolean> = MutableLiveData()
    val postLists: MutableLiveData<Resource<List<Post>>> = MutableLiveData()

    fun onUserId(userId: Int) = userIdValue.postValue(userId)


    /**
     *
     * Getting user details with parallelly depending on user id getting post details...
     *
     * @param it - clicked user id from user list.
     *
     * */
    fun getUserDetails(it: Int) {
        if (checkInternetConnectionWithMessage()) {
            userProfilePbLoading.postValue(true)
            compositeDisposable.add(
                userDetailsRepository.fetchUserDetails(it)
                !!.flatMap {
                    userProfilePbLoading.postValue(false)
                    userName.postValue(it.name)
                    userId.postValue(it.id)
                    userEmail.postValue(it.email)
                    userProfilePbLoading.postValue(true)
                    postRepository.fetchPostList(it.id)
                }
                    ?.subscribeOn(schedulerProvider.io())
                    ?.subscribe(
                        {
                            arrayListPost.addAll(it)
                            userProfilePbLoading.postValue(false)
                            postLists.postValue(Resource.success(it))
                        },
                        {
                            userProfilePbLoading.postValue(false)
                            handleNetworkError(it)
                        }
                    )!!


            )
        }
    }


    override fun onCreate() {

    }

}

