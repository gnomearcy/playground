package eu.toma.dev.playground.warcraft.talent;

import javax.inject.Inject;

import eu.toma.dev.playground.warcraft.api.WoWApi;
import eu.toma.dev.playground.warcraft.talent.Talents;
import eu.toma.dev.playground.warcraft.model.Talent;
import io.reactivex.Observable;

@Talents
public class TalentService
{
    private final WoWApi api;

    @Inject
    public TalentService(WoWApi api)
    {
        this.api = api;
    }

    public Observable<Talent> getTalents(){
        // TODO
        return null;
    }
}

