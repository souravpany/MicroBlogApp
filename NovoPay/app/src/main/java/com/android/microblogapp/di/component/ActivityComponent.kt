package com.android.microblogapp.di.component

import com.android.microblogapp.di.ActivityScope
import com.android.microblogapp.di.module.ActivityModule
import com.android.microblogapp.ui.userprofile.UserProfileActivity
import com.android.microblogapp.ui.usersection.UsersSectionActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: UsersSectionActivity)

    fun inject(activity: UserProfileActivity)

}