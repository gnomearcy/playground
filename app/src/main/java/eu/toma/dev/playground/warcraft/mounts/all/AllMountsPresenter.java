package eu.toma.dev.playground.warcraft.mounts.all;

import java.util.List;

import javax.inject.Inject;

import eu.toma.dev.playground.warcraft.Presenter;
import eu.toma.dev.playground.warcraft.api.MountService;
import eu.toma.dev.playground.warcraft.mounts.Mount;
import eu.toma.dev.playground.warcraft.mounts.di.Mounts;
import io.reactivex.Observable;

@Mounts
public class AllMountsPresenter extends Presenter<MVP.View> implements MVP.Presenter
{
    private final MountService service;

    @Inject
    public AllMountsPresenter(MountService service)
    {
        this.service = service;
    }

    @Override
    public void getMounts()
    {
        Observable<List<Mount>> mounts = service.getMounts();
    }
}
