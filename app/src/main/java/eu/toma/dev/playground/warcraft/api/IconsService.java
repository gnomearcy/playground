package eu.toma.dev.playground.warcraft.api;

import javax.inject.Inject;

import eu.toma.dev.playground.warcraft.di.Warcraft;
import io.reactivex.Observable;

@Warcraft
public class IconsService
{
    private final MediaApi api;

    @Inject
    public IconsService(MediaApi api)
    {
        this.api = api;
    }

    public Observable<?> get56Icon(){
        // TODO
        return null;
    }
}
