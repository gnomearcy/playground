package eu.toma.dev.playground.warcraft.di;

import dagger.Component;
import eu.toma.dev.playground.rx_example_one.RxOneActivity;
import eu.toma.dev.playground.warcraft.mounts.AllMountsFragment;
import eu.toma.dev.playground.warcraft.mounts.MountActivity;
import eu.toma.dev.playground.warcraft.mounts.MountDetailsFragment;
import eu.toma.dev.playground.warcraft.mounts.MountModule;

@MountScope
@Component(modules = MountModule.class)
public interface MountComponent
{
    void inject(AllMountsFragment allMounts);

    void inject(RxOneActivity act);

    void inject(MountDetailsFragment mountDetailsFragment);

    void inject(MountActivity mountsActivity);
}
