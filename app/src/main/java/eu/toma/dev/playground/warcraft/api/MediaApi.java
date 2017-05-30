package eu.toma.dev.playground.warcraft.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
* API for retrieving images and icons.
*/
public interface MediaApi
{
    @GET("56/{name}.jpg")
    Observable<?> getIcon56(@Path("name") String iconName);
}
