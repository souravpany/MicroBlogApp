package com.android.microblogapp

import android.app.Application
import com.android.microblogapp.di.component.ApplicationComponent
import com.android.microblogapp.di.component.DaggerApplicationComponent
import com.android.microblogapp.di.module.ApplicationModule

class MicroBlogApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent


    override fun onCreate() {
        super.onCreate()
        injectDependencies()

    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }


}
