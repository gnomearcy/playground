package warcraft.api

import eu.toma.dev.playground.warcraft.talent.ResponseTalents
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import warcraft.model.boss.Boss
import warcraft.mounts.ResponseGetMounts

/**
 * https://dev.battle.net/io-docs
 */
interface WoWApi {

//    @GET("wow/boss/")
//    fun getBosses(@Query(apikey) value: String): Observable<List<Boss>>
//
//    @GET("wow/boss/{bossId}")
//    fun getBoss(@Query(apikey) value: String,
//                @Path("bossId") bossId: Int): Observable<Boss>

    @GET("wow/mount/")
    fun getMounts(@Query(apikey) value: String): Observable<Response<ResponseGetMounts>>

    companion object {
        const val apikey = "apikey"
    }
}
