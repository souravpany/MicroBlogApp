package com.android.microblogapp.ui.userprofile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.microblogapp.R
import com.android.microblogapp.di.component.ActivityComponent
import com.android.microblogapp.ui.base.BaseActivity
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

        val userId = intent.getIntExtra("user_id", 0)
        viewModel.onUserId(userId)


        rvPost.apply {
            layoutManager = linearLayoutManager
            adapter = postListAdapter
        }

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
