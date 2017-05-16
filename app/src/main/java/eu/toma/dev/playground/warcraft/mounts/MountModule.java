package eu.toma.dev.playground.warcraft.mounts;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import eu.toma.dev.playground.warcraft.Config;
import eu.toma.dev.playground.warcraft.di.MountScope;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@MountScope
@Module
public class MountModule
{
    private static final int READ_TIMEOUT = 20 * 1000; // 20 seconds
    private static final int WRITE_TIMEOUT = 20 * 1000; // 20 seconds

    @MountScope
    @Provides
    public MountApiDefinition giveApi(Retrofit client){
        return client.create(MountApiDefinition.class);
    }


    @MountScope
    @Provides
    public OkHttpClient wowClient()
    {
        OkHttpClient.Builder b = new OkHttpClient.Builder();
        return b.readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS).writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS).build();
    }

    @MountScope
    @Provides
    public Retrofit apiAdapter(){
        Retrofit.Builder builder = new Retrofit.Builder();
        return builder.baseUrl(Config.BASE_URL).addCallAdapterFactory(
                RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
    }
}
