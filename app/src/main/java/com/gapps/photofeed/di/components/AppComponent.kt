package com.gapps.photofeed.di.components

import com.gapps.photofeed.PhotoFeedApplication
import com.gapps.photofeed.di.modules.AppModule
import com.gapps.photofeed.di.modules.BuildersModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton
import android.app.Application
import com.gapps.photofeed.di.modules.NetworkModule
import dagger.BindsInstance

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, NetworkModule::class,
        BuildersModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: PhotoFeedApplication)
}