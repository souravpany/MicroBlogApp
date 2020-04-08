package com.android.microblogapp.ui.userprofile.adapter

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.android.microblogapp.data.model.Post
import com.android.microblogapp.data.model.User
import com.android.microblogapp.ui.base.BaseAdapter

class PostListAdapter(
    parentLifecycle: Lifecycle,
    user: ArrayList<Post>
) : BaseAdapter<Post, PostItemViewHolder>(parentLifecycle, user) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostItemViewHolder(parent)
}