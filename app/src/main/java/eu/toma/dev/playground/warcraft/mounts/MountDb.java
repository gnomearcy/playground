package eu.toma.dev.playground.warcraft.mounts;

import java.util.List;

import javax.inject.Inject;

import eu.toma.dev.playground.warcraft.mounts.di.Mounts;
import io.reactivex.Observable;

@Mounts
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
