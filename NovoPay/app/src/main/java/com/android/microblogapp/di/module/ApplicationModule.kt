package com.android.microblogapp.di.module

import android.app.Application
import android.content.Context
import com.android.microblogapp.BuildConfig
import com.android.microblogapp.MicroBlogApplication
import com.android.microblogapp.data.remote.NetworkService
import com.android.microblogapp.di.ApplicationContext
import com.android.microblogapp.utils.network.NetworkHelper
import com.android.microblogapp.utils.rx.RxSchedulerProvider
import com.android.microblogapp.utils.rx.SchedulerProvider
import com.android.microblogapp.data.remote.Networking
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MicroBlogApplication) {

    @Singleton
    @Provides
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application


    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()


    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService = Networking.create(BuildConfig.BASE_URL, application.cacheDir, (10 * 1024 * 1024).toLong())



    @Provides
    @Singleton
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)

}
