package eu.span.dev.rxjava.warcraft;

import java.util.List;

import eu.span.dev.rxjava.warcraft.model.Boss;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
* https://dev.battle.net/io-docs
*/
public interface APIDefinition
{
    String apikey = "apikey";
    String BASE_URL = "https://eu.api.battle.net";
    @GET("/wow/boss/")
    Call<List<Boss>> getBosses(@Query(apikey) String value);

    @GET("/wow/boss/{bossId}")
    Call<Boss> getBoss(@Query(apikey) String value, @Path("bossId") int bossId);
}
