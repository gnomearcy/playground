package eu.toma.dev.playground.warcraft.mounts;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MountApiDefinition
{
    @GET("wow/mount/")
    Observable<Response<List<Mount>>> getMounts(@Query("apikey") String value);
}
