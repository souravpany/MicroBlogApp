package com.android.microblogapp.ui.usersection

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.microblogapp.R
import com.android.microblogapp.di.component.ActivityComponent
import com.android.microblogapp.ui.base.BaseActivity
import com.android.microblogapp.ui.userprofile.UserProfileActivity
import com.android.microblogapp.ui.usersection.adapter.UserListAdapter
import kotlinx.android.synthetic.main.activity_users_section.*
import javax.inject.Inject


/**
 *
 * User Section Activity - Viewing individual user details as list
 *
 * */

class UsersSectionActivity : BaseActivity<UsersSectionViewModel>() {

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var userListAdapter: UserListAdapter


    override fun provideLayoutId(): Int = R.layout.activity_users_section

    override fun injectDependencies(activityComponent: ActivityComponent) {

        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {

        rvUser.apply {
            layoutManager = linearLayoutManager
            adapter = userListAdapter
        }

        rvUser.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {

                viewModel.callUserProfileScreen(viewModel.arrayListUser[position].id)
            }
        })

    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.loading.observe(this, Observer {
            pb_loading.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.noDataFound.observe(this, Observer {
            layout_sad_path.visibility = if (it) View.VISIBLE else View.GONE
        })


        viewModel.userLists.observe(this, Observer {
            it.data?.run { userListAdapter.appendData(this) }
        })


        viewModel.launchUserProfileScreen.observe(this, Observer<Int> {
            it.run {
                doCallUserProfileModule(it)
            }
        })

    }

    /**
     * Calling User Profile Module
     *
     * @param it - clicked user id from list.
     *
     * */
    private fun doCallUserProfileModule(it: Int) {
        val userProfileScreenIntent =
            Intent(this@UsersSectionActivity, UserProfileActivity::class.java)

        userProfileScreenIntent.putExtra("user_id", it)

        startActivity(userProfileScreenIntent)
    }

}
