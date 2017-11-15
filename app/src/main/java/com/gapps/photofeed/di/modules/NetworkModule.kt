package com.gapps.photofeed.di.modules

import android.content.Context
import com.gapps.photofeed.BuildConfig
import com.gapps.photofeed.network.ApiCallExecutor
import com.gapps.photofeed.network.NoNetworkConnectionException
import com.gapps.photofeed.utils.hasNetworkConnection
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    @Module
    companion object {

        @JvmStatic
        @Singleton
        @Provides
        fun provideJsonConverter(): Moshi {
            return Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
        }

        @JvmStatic
        @Singleton
        @Provides
        fun provideHttpClient(applicationContext: Context): OkHttpClient {
            val httpClient = OkHttpClient.Builder()

            if (BuildConfig.DEBUG) {
                val httpLogger = HttpLoggingInterceptor()
                httpLogger.level = HttpLoggingInterceptor.Level.BODY
                httpClient.addInterceptor(httpLogger)
            }

            httpClient.addInterceptor { chain ->
                if (hasNetworkConnection(applicationContext)) {
                    chain.proceed(chain.request())
                } else {
                    throw NoNetworkConnectionException()
                }
            }

            return httpClient.build()
        }

        @JvmStatic
        @Singleton
        @Provides
        fun provideRestClient(converter: Moshi, httpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(BuildConfig.FLICKR_ENDPOINT)
                    .addConverterFactory(MoshiConverterFactory.create(converter))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpClient)
                    .build()
        }

        @JvmStatic
        @Singleton
        @Provides
        fun provideApiCallExecutor(retrofit: Retrofit): ApiCallExecutor {
            return ApiCallExecutor(retrofit)
        }
    }
}