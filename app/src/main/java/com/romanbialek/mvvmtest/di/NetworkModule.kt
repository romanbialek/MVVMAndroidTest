package com.romanbialek.mvvmtest.di


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.romanbialek.mvvmtest.data.repository.CharactersListRepositoryImp
import com.romanbialek.mvvmtest.data.repository.CharacterDetailRepositoryImp

import com.romanbialek.mvvmtest.data.source.RetrofitService
import com.romanbialek.mvvmtest.domain.repository.CharactersListRepository
import com.romanbialek.mvvmtest.utils.Constants.BASE_URL
import com.romanbialek.mvvmtest.utils.Constants.PUBLIC_KEY
import com.romanbialek.mvvmtest.utils.Constants.PRIVATE_KEY
import com.romanbialek.mvvmtest.domain.model.Character
import com.google.gson.Gson
import com.romanbialek.mvvmtest.domain.repository.CharacterDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.HttpUrl
import okhttp3.Request


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        @ApplicationContext context: Context
    ): OkHttpClient {
        val cacheSize = (5 * 1024 * 1024).toLong()
        val mCache = Cache(context.cacheDir, cacheSize)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .cache(mCache)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .addInterceptor { chain ->
                var original: Request = chain.request()
                val originalHttpUrl: HttpUrl = original.url
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apikey", PUBLIC_KEY)
                    .build()

                // Request customization: add request headers

                original = original.newBuilder().url(url)
                    .header("Cache-Control", "public, max-age=" + 5).build()

                chain.proceed(original)
            }
        return client.build()
    }


    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun providesRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun provideIsNetworkAvailable(@ApplicationContext context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }

    @Singleton
    @Provides
    fun provideCharactersListRepository(
        retrofitService: RetrofitService
    ): CharactersListRepository {
        return CharactersListRepositoryImp(retrofitService)
    }

    @Singleton
    @Provides
    fun provideCharacterDetailRepository(
        retrofitService: RetrofitService
    ): CharacterDetailRepository {
        return CharacterDetailRepositoryImp(retrofitService)
    }
    //@Singleton
    //@Provides
    //fun provideCharacterRepository(
    //    retrofitService: RetrofitService
    //): CharacterRepository {
    //    return CharacterRepositoryImp(retrofitService)
    //}
}