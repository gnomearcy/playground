package eu.toma.dev.playground.warcraft.mounts;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import eu.toma.dev.playground.BuildConfig;
import eu.toma.dev.playground.Callback;
import eu.toma.dev.playground.rx_example_one.RX_APP;
import eu.toma.dev.playground.warcraft.di.MountScope;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

@MountScope
public class MountService
{
    private final MountAPI api;
    private final MountDb db;
    private final MountCache cache;

    @Inject
    public MountService(MountAPI api,
                        MountDb db,
                        MountCache cache)
    {
        this.api = api;
        this.db = db;
        this.cache = cache;
    }

    /**
    *   Disposable is a Subscription.
    */
    public Disposable getMounts(final Callback<List<Mount>> callback)
    {
        final Maybe<List<Mount>> mountsFromAPI = api.getMountsFromAPI();
        final Maybe<List<Mount>> mountsFromDb = db.mountsFromDb();
        final Maybe<List<Mount>> cachedMounts = cache.getCachedMounts();

        cachedMounts.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(new Consumer<List<Mount>>()
                {
                    @Override
                    public void accept(@NonNull List<Mount> mounts) throws Exception
                    {
                        callback.onSuccess(mounts);
                    }
                })
                .doOnError(new Consumer<Throwable>()
                {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception
                    {
                        Log.d(RX_APP.TAG, "[MountService] - [accept]: cache error - " + throwable.getMessage());
                        mountsFromDb.doOnSuccess(new Consumer<List<Mount>>()
                        {
                            @Override
                            public void accept(@NonNull List<Mount> mounts) throws Exception
                            {
                                cache.save(mounts);
                                callback.onSuccess(mounts);
                            }
                        })
                        .doOnError(new Consumer<Throwable>()
                        {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception
                            {
                                Log.d(RX_APP.TAG, "[MountService] - [accept]: db error - " + throwable.getMessage());
                                mountsFromAPI.doOnSuccess(new Consumer<List<Mount>>()
                                {
                                    @Override
                                    public void accept(@NonNull List<Mount> mounts) throws Exception
                                    {

                                    }
                                })
                                    .doOnError(new Consumer<Throwable>()
                                {
                                    @Override
                                    public void accept(@NonNull Throwable throwable) throws Exception
                                    {

                                    }
                                });
                            }
                        });
                    }
                })
                .onErrorResumeNext(mountsFromDb.onErrorResumeNext(mountsFromAPI));

        mountsFromDb.onErrorResumeNext(apiSource).onErrorResumeNext(cacheObservable)
        Observable.concat(apiSource, mountsFromDb)

        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(
                new Function<Throwable, ObservableSource<? extends List<Mount>>>()
                {
                    @Override
                    public ObservableSource<? extends List<Mount>> apply(@NonNull Throwable throwable) throws Exception
                    {
                        return Observable.error(throwable);
                    }
                }).subscribe(new Consumer<List<Mount>>()
        {
            @Override
            public void accept(@NonNull List<Mount> mounts) throws Exception
            {
                
            }
        });

        return db.mountsFromDb().onErrorResumeNext(mountsFromApi);
    }
}
