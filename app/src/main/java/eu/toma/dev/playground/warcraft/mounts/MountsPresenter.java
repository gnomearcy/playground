package eu.toma.dev.playground.warcraft.mounts;

import javax.inject.Inject;

import eu.toma.dev.playground.warcraft.Mounts;
import eu.toma.dev.playground.warcraft.Presenter;
import eu.toma.dev.playground.warcraft.di.MountScope;
import io.reactivex.internal.disposables.ListCompositeDisposable;

@MountScope
public class MountsPresenter extends Presenter<Mounts.View> implements Mounts.Presenter
{
    @Inject
    public MountsPresenter()
    {
    }

    @Override
    public void getMounts()
    {
    }
}
