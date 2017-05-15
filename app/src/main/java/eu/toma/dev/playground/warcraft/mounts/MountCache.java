package eu.toma.dev.playground.warcraft.mounts;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Predicate;

@Singleton
public class MountCache
{
    private List<Mount> cachedMounts;

    @Inject
    public MountCache()
    {
    }

    public Maybe<List<Mount>> getCachedMounts()
    {
        return Observable.fromIterable(cachedMounts).toList().filter(new Predicate<List<Mount>>()
        {
            @Override
            public boolean test(@NonNull List<Mount> mounts) throws Exception
            {
                if(mounts == null){
                    throw new Exception("no cached mounts available");
                }
                return true;
            }
        });
    }

    public void save(List<Mount> mounts)
    {
        this.cachedMounts = mounts;
    }
}
