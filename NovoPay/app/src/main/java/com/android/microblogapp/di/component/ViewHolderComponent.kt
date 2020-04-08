package com.android.microblogapp.di.component


import com.android.microblogapp.di.ViewModelScope
import com.android.microblogapp.di.module.ViewHolderModule
import com.android.microblogapp.ui.userprofile.adapter.PostItemViewHolder
import com.android.microblogapp.ui.usersection.adapter.UserItemViewHolder
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

    fun inject(viewHolder: UserItemViewHolder)

    fun inject(viewHolder: PostItemViewHolder)

}