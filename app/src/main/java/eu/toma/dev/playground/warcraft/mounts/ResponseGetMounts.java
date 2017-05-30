package eu.toma.dev.playground.warcraft.mounts;

import java.util.List;

import eu.toma.dev.playground.warcraft.mounts.Mount;
import eu.toma.dev.playground.warcraft.api.WoWApi;

/**
* @see WoWApi#getMounts(String)
*/
public class ResponseGetMounts
{
    public List<Mount> mounts;
}
