package eu.toma.dev.playground.warcraft.mounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import eu.toma.dev.playground.BuildConfig;
import eu.toma.dev.playground.Utilities;
import eu.toma.dev.playground.warcraft.di.MountScope;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import retrofit2.HttpException;
import retrofit2.Response;

@MountScope
public class MountAPI
{
    private final MountApiDefinition definition;

    @Inject
    public MountAPI(MountApiDefinition definition)
    {
        this.definition = definition;
    }

    public Observable<List<Mount>> getMountsFromAPI()
    {
        return definition.getMounts(BuildConfig.WOW_API_KEY)
                .map(new Function<Response<List<Mount>>, List<Mount>> ()
                {
                    @Override
                    public List<Mount> apply(@NonNull Response<List<Mount>> listResponse) throws Exception
                    {
                        if(listResponse.code() != 200){
                            throw new HttpException(listResponse);
                        }
                        Utilities.nullCheck(listResponse.body());
                        return listResponse.body();
                    }
                })
                .singleElement()
                .filter(new Predicate<List<Mount>>()
                {
                    @Override
                    public boolean test(@NonNull List<Mount> mounts) throws Exception
                    {
                        Utilities.nullCheck(mounts);
                        return true;
                    }
                }).toObservable();
    }

//    private List<Mount> mockedData()
//    {
//        final int size = 5;
//        final String[] names = {
//                "Bob",
//                "alice",
//                "jenny",
//                "tom",
//                "john"};
//        List<Mount> r = new ArrayList<>(size);
//        for(int i = 0; i < size; i++)
//        {
//            Mount m = new Mount();
//            m.name = names[new Random().nextInt(size)];
//            r.add(m);
//        }
//        return r;
//    }
}
