package com.android.microblogapp.ui.userprofile.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.android.microblogapp.data.model.Post
import com.android.microblogapp.ui.base.BaseItemViewModel
import com.android.microblogapp.utils.network.NetworkHelper
import com.android.microblogapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PostItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<Post>(schedulerProvider, compositeDisposable, networkHelper) {


    val title: LiveData<String> = Transformations.map(data) { "Title: " + it.title }
    val id: LiveData<String> = Transformations.map(data) { "Id: " + it.id.toString() }
    val userId: LiveData<String> = Transformations.map(data) { "User Id: " + it.userId.toString() }
    val body: LiveData<String> = Transformations.map(data) { "Body: " + it.body }


    override fun onCreate() {}
}