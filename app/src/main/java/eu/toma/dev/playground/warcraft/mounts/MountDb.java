package eu.toma.dev.playground.warcraft.mounts;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import eu.toma.dev.playground.Utilities;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

@Singleton
public class MountDb
{
    private List<Mount> mountsInDb;

    @Inject
    public MountDb()
    {
    }

    public Maybe<List<Mount>> mountsFromDb()
    {
        return Observable.fromIterable(mountsInDb).toList().filter(new Predicate<List<Mount>>()
        {
            @Override
            public boolean test(@NonNull List<Mount> mounts) throws Exception
            {
                Utilities.nullCheck(mounts);
                return true;
            }
        });
    }
}
