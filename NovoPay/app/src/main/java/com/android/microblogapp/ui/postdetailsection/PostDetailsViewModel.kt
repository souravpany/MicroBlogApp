package com.android.microblogapp.ui.postdetailsection

import androidx.lifecycle.MutableLiveData
import com.android.microblogapp.data.model.Comment
import com.android.microblogapp.data.repository.CommentDetailRepository
import com.android.microblogapp.data.repository.PostDetailRepository
import com.android.microblogapp.ui.base.BaseViewModel
import com.android.microblogapp.utils.common.Resource
import com.android.microblogapp.utils.network.NetworkHelper
import com.android.microblogapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class PostDetailsViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val arrayListComment: ArrayList<Comment>,
    private val postDetailRepository: PostDetailRepository,
    private val commentDetailRepository: CommentDetailRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {


    val userIdValue: MutableLiveData<Int> = MutableLiveData()
    val userPostDetailPbLoading: MutableLiveData<Boolean> = MutableLiveData()
    val postTitle: MutableLiveData<String> = MutableLiveData()
    val id: MutableLiveData<Int> = MutableLiveData()
    val postBody: MutableLiveData<String> = MutableLiveData()
    val userId: MutableLiveData<Int> = MutableLiveData()
    val commentLists: MutableLiveData<Resource<List<Comment>>> = MutableLiveData()

    fun onUserId(userId: Int) = userIdValue.postValue(userId)


    /**
     *
     * Getting post details with parallelly depending on id getting comment details...
     *
     * @param it - clicked id from post list.
     *
     * */
    fun getPostDetails(it: Int) {
        if (checkInternetConnectionWithMessage()) {
            userPostDetailPbLoading.postValue(true)
            compositeDisposable.add(
                postDetailRepository.fetchPostDetails(it)
                !!.flatMap {
                    userPostDetailPbLoading.postValue(false)
                    postTitle.postValue(it.title)
                    userId.postValue(it.userId)
                    id.postValue(it.id)
                    postBody.postValue(it.body)
                    userPostDetailPbLoading.postValue(true)
                    commentDetailRepository.fetchCommentList(it.id)
                }
                    ?.subscribeOn(schedulerProvider.io())
                    ?.subscribe(
                        {
                            arrayListComment.addAll(it)
                            userPostDetailPbLoading.postValue(false)
                            commentLists.postValue(Resource.success(it))
                        },
                        {
                            userPostDetailPbLoading.postValue(false)
                            handleNetworkError(it)
                        }
                    )!!


            )
        }
    }


    override fun onCreate() {

    }


}