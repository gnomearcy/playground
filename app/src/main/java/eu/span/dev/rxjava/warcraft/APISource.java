package eu.span.dev.rxjava.warcraft;

import java.util.List;

import eu.span.dev.rxjava.warcraft.model.Boss;

public interface APISource
{
    List<Boss> getAllBosses();

    Boss getBoss(int bossId);
}
