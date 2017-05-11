package eu.span.dev.rxjava.warcraft;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import eu.span.dev.rxjava.BuildConfig;
import eu.span.dev.rxjava.warcraft.model.Boss;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

@Singleton
public class APIWow implements APISource
{
    private static final String API_KEY = BuildConfig.WOW_API_KEY;
    private final APIDefinition apiDefinition;

    @Inject
    public APIWow(APIDefinition apiDefinition)
    {
        this.apiDefinition = apiDefinition;
    }

    @Override
    public List<Boss> getAllBosses()
    {
        Observable<List<Boss>> bossSource = Observable.fromCallable(new Callable<List<Boss>>()
        {
            @Override
            public List<Boss> call() throws Exception
            {
                return null;
            }
        });
        bossSource.map(new Function<List<Boss>, Object>()
        {
            @Override
            public Object apply(@NonNull List<Boss> bosses) throws Exception
            {
                return null;
            }
        })
    }

    @Override
    public Boss getBoss(int bossId)
    {
        return null;
    }
}
