package eu.toma.dev.playground.warcraft;

import java.util.List;

import eu.toma.dev.playground.warcraft.model.boss.Boss;
import eu.toma.dev.playground.warcraft.mounts.Mount;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
* https://dev.battle.net/io-docs
*/
public interface APIDefinition
{
    String apikey = "apikey";
    String BASE_URL = "https://eu.api.battle.net/";

    @GET("wow/boss/")
    Observable<List<Boss>> getBosses(@Query(apikey) String value);

    @GET("wow/boss/{bossId}")
    Observable<Boss> getBoss(@Query(apikey) String value, @Path("bossId") int bossId);


    @GET("wow/mount/")
    Observable<List<Mount>> getAllMounts(@Query(apikey) String value);

}
