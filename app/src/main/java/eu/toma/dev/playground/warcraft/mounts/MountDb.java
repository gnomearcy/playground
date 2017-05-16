package eu.toma.dev.playground.warcraft.mounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;

import eu.toma.dev.playground.Utilities;
import eu.toma.dev.playground.warcraft.di.MountScope;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.single.SingleToObservable;

@MountScope
public class MountDb
{
    private List<Mount> mounts;

    @Inject
    public MountDb()
    {
    }



    public Observable<List<Mount>> mountsFromDb()
    {
        if(mounts == null){
            return Observable.error(new Exception("db null mounts"));
        } else {
            return Observable.fromIterable(mounts).toList().toObservable();
        }
    }

    public void save(List<Mount> mounts)
    {
        this.mounts = mounts;
    }
}
