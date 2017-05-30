package eu.toma.dev.playground.warcraft.api;

import java.util.List;

import eu.toma.dev.playground.warcraft.model.boss.Boss;
import eu.toma.dev.playground.warcraft.mounts.ResponseGetMounts;
import eu.toma.dev.playground.warcraft.talent.ResponseTalents;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
* https://dev.battle.net/io-docs
*/
public interface WoWApi
{
    String apikey = "apikey";

    @GET("wow/boss/")
    Observable<List<Boss>> getBosses(@Query(apikey) String value);

    @GET("wow/boss/{bossId}")
    Observable<Boss> getBoss(@Query(apikey) String value, @Path("bossId") int bossId);

    @GET("wow/mount/")
    Observable<Response<ResponseGetMounts>> getMounts(@Query(apikey) String value);

    @GET
    Observable<ResponseTalents> getTalents(@Query(apikey)  String value);
}
