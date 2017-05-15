package eu.toma.dev.playground.warcraft;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import eu.toma.dev.playground.BuildConfig;
import eu.toma.dev.playground.warcraft.model.boss.Boss;

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
        return null;
    }

    @Override
    public Boss getBoss(int bossId)
    {
        return null;
    }
}
