package com.android.microblogapp.ui.postdetailsection

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.microblogapp.R
import com.android.microblogapp.di.component.ActivityComponent
import com.android.microblogapp.ui.base.BaseActivity
import com.android.microblogapp.ui.postdetailsection.adapter.CommentListAdapter
import kotlinx.android.synthetic.main.activity_post_details.*
import javax.inject.Inject

/**
 * Post Details Activity - Basically Populating the individual post and their corresponding comments.
 *
 * */

class PostDetailsActivity : BaseActivity<PostDetailsViewModel>() {

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var commentListAdapter: CommentListAdapter


    override fun provideLayoutId(): Int = R.layout.activity_post_details

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {

        val ab = supportActionBar
        if (ab != null) {
            ab.setDisplayShowHomeEnabled(true) // show or hide the default home button
            ab.setDisplayHomeAsUpEnabled(true)
        }

        // receiving post id from User Profile Activity
        val userId = intent.getIntExtra("post_id", 0)
        viewModel.onUserId(userId)


        rvComment.apply {
            layoutManager = linearLayoutManager
            adapter = commentListAdapter
        }


    }

    @SuppressLint("SetTextI18n")
    override fun setupObservers() {
        super.setupObservers()



        viewModel.userIdValue.observe(this, Observer {
            viewModel.getPostDetails(it)
        })



        viewModel.userPostDetailPbLoading.observe(this, Observer {
            postLoading.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.postTitle.observe(this, Observer {
            if (it.isNotEmpty() || it != "") txtPostTitle.text = "Post Title: $it"
        })

        viewModel.id.observe(this, Observer {
            if (it != 0) txtPostId.text = "Id: $it"
        })

        viewModel.userId.observe(this, Observer {
            if (it != 0) txtUserId.text = "UserId: $it"
        })

        viewModel.postBody.observe(this, Observer {
            if (it.isNotEmpty() || it != "") txtPostBody.text = it
        })


        viewModel.commentLists.observe(this, Observer {
            it.data?.run { commentListAdapter.appendData(this) }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return true
    }


}
