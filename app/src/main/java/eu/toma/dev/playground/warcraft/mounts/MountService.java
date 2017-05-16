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
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
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
    public void getMounts(final Callback<List<Mount>> callback)
    {
        final Observable<List<Mount>> mountsFromAPI = api.getMountsFromAPI();
        final Observable<List<Mount>> mountsFromDb = db.mountsFromDb();
        final Observable<List<Mount>> cachedMounts = cache.getCachedMounts();


        final Observer<List<Mount>> ob = new DisposableObserver<List<Mount>>()
        {
            @Override
            public void onNext(@NonNull List<Mount> mounts)
            {
                Log.d(RX_APP.TAG, "[MountService] - [onNext]: ");
                callback.onSuccess(mounts);
            }

            @Override
            public void onError(@NonNull Throwable e)
            {
                Log.d(RX_APP.TAG, "[MountService] - [onError]: ");
                callback.onError();
            }

            @Override
            public void onComplete()
            {
                Log.d(RX_APP.TAG, "[MountService] - [onComplete]: ");
            }
        };

        cachedMounts.doOnNext(new Consumer<List<Mount>>()
                {
                    @Override
                    public void accept(@NonNull List<Mount> mounts) throws Exception
                    {
                        Log.d(RX_APP.TAG, "[MountService] - [accept]: returning items from CACHE");
                        callback.onSuccess(mounts);
                    }
                })
//                .onErrorResumeNext(mountsFromDb)
                .onExceptionResumeNext(mountsFromDb);

        mountsFromDb.doOnNext(new Consumer<List<Mount>>()
        {
            @Override
            public void accept(@NonNull List<Mount> mounts) throws Exception
            {
                Log.d(RX_APP.TAG, "[MountService] - [accept]: returning items from DATABASE");
                cache.save(mounts);
                callback.onSuccess(mounts);
            }
        })
//        .onErrorResumeNext(mountsFromAPI);
        .onExceptionResumeNext(mountsFromAPI);

        mountsFromAPI.doOnNext(new Consumer<List<Mount>>()
        {
            @Override
            public void accept(@NonNull List<Mount> mounts) throws Exception
            {
                Log.d(RX_APP.TAG, "[MountService] - [accept]: returning items from API");
                db.save(mounts);
                callback.onSuccess(mounts);
            }
        })
        .doOnError(new Consumer<Throwable>()
        {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception
            {
                ob.onError(throwable);
            }
        });

        cachedMounts.subscribe(ob);
    }
}
