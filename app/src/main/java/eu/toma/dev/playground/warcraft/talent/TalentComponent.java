package eu.toma.dev.playground.warcraft.talent;

import dagger.Component;
import eu.toma.dev.playground.warcraft.di.WoWcomponent;

@Talents
@Component(dependencies = WoWcomponent.class)
public interface TalentComponent
{
    void inject(TalentsActivity talents);
}
