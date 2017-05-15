package eu.toma.dev.playground.warcraft.mounts;

import java.util.List;

import eu.toma.dev.playground.BuildConfig;
import eu.toma.dev.playground.Utilities;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import retrofit2.Response;

public class MountAPI
{
    private final MountApiDefinition definition;

    public MountAPI(MountApiDefinition definition)
    {
        this.definition = definition;
    }

    public Maybe<List<Mount>> getMountsFromAPI()
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
                });
    }
}
