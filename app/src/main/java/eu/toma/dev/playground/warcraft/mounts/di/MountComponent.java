package eu.toma.dev.playground.warcraft.mounts.di;

import dagger.Component;
import eu.toma.dev.playground.rx_example_one.RxOneActivity;
import eu.toma.dev.playground.warcraft.di.WoWcomponent;
import eu.toma.dev.playground.warcraft.mounts.MountsActivity;
import eu.toma.dev.playground.warcraft.mounts.all.AllMountsFragment;
import eu.toma.dev.playground.warcraft.mounts.details.MountDetailsFragment;

@Mounts
@Component(dependencies = WoWcomponent.class)
public interface MountComponent
{
    void inject(AllMountsFragment allMounts);

    void inject(MountDetailsFragment mountDetailsFragment);

    void inject(MountsActivity mountsActivity);
}
