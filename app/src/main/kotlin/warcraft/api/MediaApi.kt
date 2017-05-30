package warcraft.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * API for retrieving images and icons.
 */
interface MediaApi {
    @GET("56/{name}.jpg")
    fun getIcon56(@Path("name") iconName: String): Observable<*>
}
