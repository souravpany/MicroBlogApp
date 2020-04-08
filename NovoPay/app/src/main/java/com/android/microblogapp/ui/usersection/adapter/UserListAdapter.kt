package com.android.microblogapp.ui.usersection.adapter

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.android.microblogapp.data.model.User
import com.android.microblogapp.ui.base.BaseAdapter

class UserListAdapter(
    parentLifecycle: Lifecycle,
    user: ArrayList<User>
) : BaseAdapter<User, UserItemViewHolder>(parentLifecycle, user) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserItemViewHolder(parent)
}