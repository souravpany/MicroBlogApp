package com.android.microblogapp.ui.postdetailsection.adapter

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.android.microblogapp.data.model.Comment
import com.android.microblogapp.data.model.Post
import com.android.microblogapp.data.model.User
import com.android.microblogapp.ui.base.BaseAdapter

class CommentListAdapter(
    parentLifecycle: Lifecycle,
    comment: ArrayList<Comment>
) : BaseAdapter<Comment, CommentItemViewHolder>(parentLifecycle, comment) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommentItemViewHolder(parent)
}