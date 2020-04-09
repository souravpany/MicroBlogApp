package com.android.microblogapp.ui.postdetailsection.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.android.microblogapp.data.model.Comment
import com.android.microblogapp.data.model.Post
import com.android.microblogapp.ui.base.BaseItemViewModel
import com.android.microblogapp.utils.network.NetworkHelper
import com.android.microblogapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CommentItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<Comment>(schedulerProvider, compositeDisposable, networkHelper) {


    val id: LiveData<String> = Transformations.map(data) { "Id: " + it.id.toString() }
    val postID: LiveData<String> = Transformations.map(data) { "Post Id: " + it.postID.toString() }
    val name: LiveData<String> = Transformations.map(data) { "Name: " + it.name }
    val email: LiveData<String> = Transformations.map(data) { "Email: " + it.email }
    val body: LiveData<String> = Transformations.map(data) { "Body: " + it.body }


    override fun onCreate() {}
}