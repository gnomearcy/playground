package eu.toma.dev.playground.warcraft.mounts;

import eu.toma.dev.playground.warcraft.api.MountService;

public class MountsModel
{
    private final MountService api;

    public MountsModel(MountService api)
    {
        this.api = api;
    }
}
