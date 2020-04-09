package com.android.microblogapp.ui.userprofile.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.android.microblogapp.R
import com.android.microblogapp.data.model.Post
import com.android.microblogapp.di.component.ViewHolderComponent
import com.android.microblogapp.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.row_post_view.view.*

class PostItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<Post, PostItemViewModel>(R.layout.row_post_view, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.id.observe(this, Observer {
            itemView.txtId.text = it
        })

        viewModel.userId.observe(this, Observer {
            itemView.txtUserId.text = it
        })

        viewModel.body.observe(this, Observer {
            itemView.txtBody.text = it
        })


        viewModel.title.observe(this, Observer {
            itemView.txtTitle.text = it
        })

    }

    override fun setupView(view: View) {}
}