package com.android.microblogapp.ui.userprofile

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.microblogapp.R
import com.android.microblogapp.di.component.ActivityComponent
import com.android.microblogapp.ui.base.BaseActivity
import com.android.microblogapp.ui.postdetailsection.PostDetailsActivity
import com.android.microblogapp.ui.userprofile.adapter.PostListAdapter
import kotlinx.android.synthetic.main.activity_user_profile.*
import javax.inject.Inject


/**
 *
 * User Profile Activity - Viewing individual user details parallelly getting all post regards to that.
 *
 * */

class UserProfileActivity : BaseActivity<UserProfileViewModel>() {


    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var postListAdapter: PostListAdapter


    override fun provideLayoutId(): Int = R.layout.activity_user_profile


    override fun injectDependencies(activityComponent: ActivityComponent) {

        activityComponent.inject(this)
    }


    override fun setupView(savedInstanceState: Bundle?) {

        val ab = supportActionBar
        if (ab != null) {
            ab.setDisplayShowHomeEnabled(true) // show or hide the default home button
            ab.setDisplayHomeAsUpEnabled(true)
        }

        // receiving user id from Users Section Activity
        val userId = intent.getIntExtra("user_id", 0)
        viewModel.onUserId(userId)


        rvPost.apply {
            layoutManager = linearLayoutManager
            adapter = postListAdapter
        }


        rvPost.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {

                viewModel.callPostDetailScreen(viewModel.arrayListPost[position].id)
            }
        })

    }

    @SuppressLint("SetTextI18n")
    override fun setupObservers() {
        super.setupObservers()

        viewModel.userProfilePbLoading.observe(this, Observer {
            userProfileLoading.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.userName.observe(this, Observer {
            if (it.isNotEmpty() || it != "") txtProfileName.text = "Name: $it"
        })

        viewModel.userEmail.observe(this, Observer {
            if (it.isNotEmpty() || it != "") txtProfileEmail.text = "Email: $it"
        })

        viewModel.userId.observe(this, Observer {
            if (it != 0) txtProfileId.text = "Id: $it"
        })

        viewModel.userIdValue.observe(this, Observer {
            viewModel.getUserDetails(it)
        })

        viewModel.postLists.observe(this, Observer {
            it.data?.run { postListAdapter.appendData(this) }
        })

        viewModel.launchPostDetailsScreen.observe(this, Observer<Int> {
            it.run {
                doCallUserProfileModule(it)
            }
        })

    }

    /**
     * Calling Post Details Module
     *
     * @param it - clicked user id from list.
     *
     * */
    private fun doCallUserProfileModule(it: Int) {
        val userPostDetailScreenIntent =
            Intent(this@UserProfileActivity, PostDetailsActivity::class.java)

        userPostDetailScreenIntent.putExtra("post_id", it)

        startActivity(userPostDetailScreenIntent)
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
