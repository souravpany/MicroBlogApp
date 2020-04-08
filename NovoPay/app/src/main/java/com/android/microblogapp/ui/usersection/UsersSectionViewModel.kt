package com.android.microblogapp.ui.usersection

import androidx.lifecycle.MutableLiveData
import com.android.microblogapp.data.model.User
import com.android.microblogapp.data.repository.UserRepository
import com.android.microblogapp.ui.base.BaseViewModel
import com.android.microblogapp.utils.common.Resource
import com.android.microblogapp.utils.network.NetworkHelper
import com.android.microblogapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class UsersSectionViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    val arrayListUser: ArrayList<User>,
    userRepository: UserRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {


    val userLists: MutableLiveData<Resource<List<User>>> = MutableLiveData()
    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val noDataFound: MutableLiveData<Boolean> = MutableLiveData()

    val launchUserProfileScreen: MutableLiveData<Int> = MutableLiveData()


    /**
     * init block for getting user details.
     * */
    init {

        if (checkInternetConnectionWithMessage()) {
            loading.postValue(true)
            compositeDisposable.addAll(
                userRepository.fetchUserList()
                    ?.subscribeOn(schedulerProvider.io())
                    ?.subscribe(
                        {
                            arrayListUser.addAll(it)
                            loading.postValue(false)
                            noDataFound.postValue(false)
                            userLists.postValue(Resource.success(it))
                        },
                        {
                            handleNetworkError(it)
                            loading.postValue(false)
                            noDataFound.postValue(true)
                        }

                    )

            )
        }
    }


    /**
     * calling user profile screen activity by passing user_id.
     *
     * */
    fun callUserProfileScreen(id: Int) {
        launchUserProfileScreen.postValue(id)
    }

    override fun onCreate() {
    }
}