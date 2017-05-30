package eu.toma.dev.playground.warcraft.api;

import java.util.List;

import javax.inject.Inject;

import eu.toma.dev.playground.BuildConfig;
import eu.toma.dev.playground.Utilities;
import eu.toma.dev.playground.warcraft.mounts.MountCache;
import eu.toma.dev.playground.warcraft.mounts.MountDb;
import eu.toma.dev.playground.warcraft.mounts.di.Mounts;
import eu.toma.dev.playground.warcraft.mounts.Mount;
import eu.toma.dev.playground.warcraft.mounts.ResponseGetMounts;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import retrofit2.Response;

@Mounts
public class MountService
{
    private final WoWApi definition;
    private final MountDb db;
    private final MountCache cache;

    @Inject
    public MountService(WoWApi definition,
                        MountDb db,
                        MountCache cache)
    {
        this.definition = definition;
        this.db = db;
        this.cache = cache;
    }

    public Observable<List<Mount>> getMounts()
    {
        // TODO chain the cache -> db -> api observables
        return definition.getMounts(BuildConfig.WOW_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Response<ResponseGetMounts>, List<Mount>>()
                {
                    @Override
                    public List<Mount> apply(@NonNull Response<ResponseGetMounts> listResponse) throws Exception
                    {
                        if(listResponse.code() != 200)
                        {
                            throw new HttpException(listResponse);
                        }
                        List<Mount> r = listResponse.body().mounts;
                        Utilities.nullCheck(r);
                        return r;
                    }
                })
                .singleElement()
                .toObservable();
    }
}
