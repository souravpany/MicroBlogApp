package com.android.microblogapp.ui.usersection.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.android.microblogapp.R
import com.android.microblogapp.data.model.User
import com.android.microblogapp.di.component.ViewHolderComponent
import com.android.microblogapp.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.row_user_view.view.*

class UserItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<User, UserItemViewModel>(R.layout.row_user_view, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.id.observe(this, Observer {
            itemView.txtUserId.text = it
        })

        viewModel.name.observe(this, Observer {
            itemView.txtName.text = it
        })

        viewModel.email.observe(this, Observer {
            itemView.txtEmail.text = it
        })

    }

    override fun setupView(view: View) {}
}