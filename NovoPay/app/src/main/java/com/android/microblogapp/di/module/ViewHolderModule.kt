package com.android.microblogapp.di.module

import androidx.lifecycle.LifecycleRegistry
import com.android.microblogapp.di.ViewModelScope
import com.android.microblogapp.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}