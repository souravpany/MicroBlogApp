package com.android.microblogapp.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.microblogapp.data.repository.PostRepository
import com.android.microblogapp.data.repository.UserDetailsRepository
import com.android.microblogapp.data.repository.UserRepository
import com.android.microblogapp.ui.base.BaseActivity
import com.android.microblogapp.ui.userprofile.UserProfileViewModel
import com.android.microblogapp.ui.userprofile.adapter.PostListAdapter
import com.android.microblogapp.ui.usersection.UsersSectionViewModel
import com.android.microblogapp.ui.usersection.adapter.UserListAdapter
import com.android.microblogapp.utils.ViewModelProviderFactory
import com.android.microblogapp.utils.network.NetworkHelper
import com.android.microblogapp.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideUserListAdapter() = UserListAdapter(activity.lifecycle, ArrayList())

    @Provides
    fun providePostListAdapter() = PostListAdapter(activity.lifecycle, ArrayList())


    @Provides
    fun provideUsersSectionViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper, userRepository: UserRepository
    ): UsersSectionViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(UsersSectionViewModel::class) {
            UsersSectionViewModel(
                schedulerProvider, compositeDisposable, networkHelper, ArrayList(),
                userRepository
            )
        }).get(UsersSectionViewModel::class.java)

    @Provides
    fun provideUsersProfileViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userDetailsRepository: UserDetailsRepository,
        postRepository: PostRepository
    ): UserProfileViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(UserProfileViewModel::class) {
            UserProfileViewModel(
                schedulerProvider, compositeDisposable, networkHelper, ArrayList(),
                userDetailsRepository, postRepository
            )
        }).get(UserProfileViewModel::class.java)

}