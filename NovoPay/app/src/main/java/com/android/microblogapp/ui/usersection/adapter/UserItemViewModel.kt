package com.android.microblogapp.ui.usersection.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.android.microblogapp.data.model.User
import com.android.microblogapp.utils.network.NetworkHelper
import com.android.microblogapp.utils.rx.SchedulerProvider
import com.android.microblogapp.ui.base.BaseItemViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class UserItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<User>(schedulerProvider, compositeDisposable, networkHelper) {


    val name: LiveData<String> = Transformations.map(data) { "Name: " + it.name }
    val email: LiveData<String> = Transformations.map(data) { "Email: " + it.email }
    val id: LiveData<String> = Transformations.map(data) { "Id: " + it.id.toString() }


    override fun onCreate() {}
}