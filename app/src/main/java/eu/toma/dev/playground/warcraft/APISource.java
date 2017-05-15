package eu.toma.dev.playground.warcraft;

import java.util.List;

import eu.toma.dev.playground.warcraft.model.boss.Boss;

public interface APISource
{
    List<Boss> getAllBosses();

    Boss getBoss(int bossId);
}
