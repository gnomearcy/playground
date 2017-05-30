package eu.toma.dev.playground.warcraft.di;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import eu.toma.dev.playground.warcraft.api.MediaApi;
import eu.toma.dev.playground.warcraft.api.WoWApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class WoWModule
{
    // Logging
    public static final String WOW_TAG = "WarcraftTag";

    // Media objects
    private static final String MEDIA_LOGGER = "media_logger";
    private static final String MEDIA_CLIENT = "media_client";
    private static final String MEDIA_BASE_URL = "http://media.blizzard.com/wow/icons/";

    // API objects
    private static final String API_LOGGER = "api_logger";
    private static final String API_CLIENT = "api_client";
    private static final String API_BASE_URL = "https://eu.api.battle.net/";

    private static final int READ_TIMEOUT = 20 * 1000; // 20 seconds
    private static final int WRITE_TIMEOUT = 20 * 1000; // 20 seconds

    @Warcraft
    @Provides
    public WoWApi provideWowApi(@Named(API_CLIENT) Retrofit r){
        return r.create(WoWApi.class);
    }

    @Warcraft
    @Provides
    public MediaApi provideMediaApi(@Named(MEDIA_CLIENT) Retrofit r){
        return r.create(MediaApi.class);
    }

    @Warcraft
    @Provides
    @Named(API_CLIENT)
    public Retrofit giveApiClient(@Named(API_LOGGER) HttpLoggingInterceptor apiLogger)
    {
        OkHttpClient.Builder cb = new OkHttpClient.Builder();
        cb.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS).readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(apiLogger)
                .build();
        Retrofit.Builder builder = new Retrofit.Builder();
        return builder.baseUrl(API_BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(cb.build())
                .addConverterFactory(
                GsonConverterFactory.create()).build();
    }

    @Warcraft
    @Provides
    @Named(MEDIA_CLIENT)
    public Retrofit mediaClient(@Named(MEDIA_LOGGER) HttpLoggingInterceptor mediaLogger)
    {
        OkHttpClient.Builder c = new OkHttpClient.Builder();
        OkHttpClient client = c.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS).writeTimeout(
                WRITE_TIMEOUT,
                TimeUnit.SECONDS).addInterceptor(mediaLogger).build();
        Retrofit.Builder b = new Retrofit.Builder();
        return b.baseUrl(MEDIA_BASE_URL).client(client).build();
    }

    @Warcraft
    @Provides
    @Named(MEDIA_LOGGER)
    public HttpLoggingInterceptor mediaLogger()
    {
        HttpLoggingInterceptor h = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger()
        {
            @Override
            public void log(String message)
            {
                Log.d(WOW_TAG, "[ media ] - " + message);
            }
        });
        h.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return h;
    }

    @Warcraft
    @Provides
    @Named(API_LOGGER)
    public HttpLoggingInterceptor apiLogger()
    {
        HttpLoggingInterceptor h = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger()
        {
            @Override
            public void log(String message)
            {
                Log.d(WOW_TAG, "[ api ] - " + message);
            }
        });
        h.setLevel(HttpLoggingInterceptor.Level.BODY);
        return h;
    }
}