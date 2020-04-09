package com.android.microblogapp.ui.postdetailsection.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.android.microblogapp.R
import com.android.microblogapp.data.model.Comment
import com.android.microblogapp.di.component.ViewHolderComponent
import com.android.microblogapp.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.row_comment_view.view.*

class CommentItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<Comment, CommentItemViewModel>(R.layout.row_comment_view, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.id.observe(this, Observer {
            itemView.txtId.text = it
        })

        viewModel.postID.observe(this, Observer {
            itemView.txtPostId.text = it
        })

        viewModel.name.observe(this, Observer {
            itemView.txtName.text = it
        })

        viewModel.email.observe(this, Observer {
            itemView.txtEmail.text = it
        })

        viewModel.body.observe(this, Observer {
            itemView.txtBody.text = it
        })


    }

    override fun setupView(view: View) {}
}