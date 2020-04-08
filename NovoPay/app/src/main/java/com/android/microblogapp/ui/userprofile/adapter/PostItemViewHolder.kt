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

        viewModel.title.observe(this, Observer {
            itemView.txtTitle.text = it
        })

    }

    override fun setupView(view: View) {}
}