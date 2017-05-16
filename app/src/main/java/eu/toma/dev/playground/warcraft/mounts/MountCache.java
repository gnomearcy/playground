package eu.toma.dev.playground.warcraft.mounts;

import java.util.List;

import javax.inject.Inject;

import eu.toma.dev.playground.warcraft.di.MountScope;
import io.reactivex.Observable;

@MountScope
public class MountCache
{
    private List<Mount> cachedMounts;

    @Inject
    public MountCache()
    {
    }

    public Observable<List<Mount>> getCachedMounts()
    {
        if(cachedMounts != null){
            return Observable.fromIterable(cachedMounts).toList().toObservable();
        } else {
            return Observable.error(new Exception("no cached mounts available"));
        }
    }

    public void save(List<Mount> mounts)
    {
        this.cachedMounts = mounts;
    }
}
