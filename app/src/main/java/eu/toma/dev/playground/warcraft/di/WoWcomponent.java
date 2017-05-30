package eu.toma.dev.playground.warcraft.di;

import javax.inject.Named;

import dagger.Component;
import eu.toma.dev.playground.GlobalComp;
import eu.toma.dev.playground.warcraft.api.MountService;

@Warcraft
@Component(modules = WoWModule.class, dependencies = GlobalComp.class)
public interface WoWcomponent
{

}
