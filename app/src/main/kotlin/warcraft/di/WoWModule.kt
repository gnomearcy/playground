package warcraft.di

import android.util.Log

import java.util.concurrent.TimeUnit

import javax.inject.Named

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import warcraft.api.MediaApi
import warcraft.api.WoWApi

@Module
class WoWModule
{
    companion object {
        // Logging
        val WOW_TAG = "WarcraftTag"

        // Media objects
        private const val MEDIA_LOGGER = "media_logger"
        private const val MEDIA_CLIENT = "media_client"
        private const val MEDIA_BASE_URL = "http://media.blizzard.com/wow/icons/"

        // API objects
        private const val API_LOGGER = "api_logger"
        private const val API_CLIENT = "api_client"
        private const val API_BASE_URL = "https://eu.api.battle.net/"

        private const val READ_TIMEOUT = 20 * 1000 // 20 seconds
        private const val WRITE_TIMEOUT = 20 * 1000 // 20 seconds
    }
    @Warcraft
    @Provides
    fun provideWowApi(@Named(API_CLIENT) r: Retrofit): WoWApi {
        return r.create(WoWApi::class.java)
    }

    @Warcraft
    @Provides
    fun provideMediaApi(@Named(MEDIA_CLIENT) r: Retrofit): MediaApi {
        return r.create(MediaApi::class.java)
    }

    @Warcraft
    @Provides
    @Named(API_CLIENT)
    fun giveApiClient(@Named(API_LOGGER) apiLogger: HttpLoggingInterceptor): Retrofit {
        val cb = OkHttpClient.Builder()
        cb.writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS).readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS).addInterceptor(apiLogger).build()
        val builder = Retrofit.Builder()
        return builder.baseUrl(API_BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(cb.build()).addConverterFactory(
                GsonConverterFactory.create()).build()
    }

    @Warcraft
    @Provides
    @Named(MEDIA_CLIENT)
    fun mediaClient(@Named(MEDIA_LOGGER) mediaLogger: HttpLoggingInterceptor): Retrofit {
        val c = OkHttpClient.Builder()
        val client = c.readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS).writeTimeout(
                WRITE_TIMEOUT.toLong(),
                TimeUnit.SECONDS).addInterceptor(mediaLogger).build()
        val b = Retrofit.Builder()
        return b.baseUrl(MEDIA_BASE_URL).client(client).build()
    }

    @Warcraft
    @Provides
    @Named(MEDIA_LOGGER)
    fun mediaLogger(): HttpLoggingInterceptor {
        val h = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.d(WOW_TAG, "[ media ] - " + message) })
        h.level = HttpLoggingInterceptor.Level.BASIC
        return h
    }

    @Warcraft
    @Provides
    @Named(API_LOGGER)
    fun apiLogger(): HttpLoggingInterceptor {
        val h = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.d(WOW_TAG, "[ api ] - " + message) })
        h.level = HttpLoggingInterceptor.Level.BODY
        return h
    }
}