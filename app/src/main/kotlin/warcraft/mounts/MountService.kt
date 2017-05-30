package warcraft.mounts

import eu.toma.dev.playground.BuildConfig
import eu.toma.dev.playground.Utilities
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import warcraft.api.WoWApi
import warcraft.mounts.di.Mounts
import javax.inject.Inject

@Mounts
class MountService
@Inject
constructor(private val definition: WoWApi,
            private val db: MountDb,
            private val cache: MountCache) {

    // TODO chain the cache -> db -> api observables
    val mounts: Observable<List<Mount>>
        get() = definition.getMounts(BuildConfig.WOW_API_KEY).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map { listResponse ->
            if (listResponse.code() != 200) {
                throw HttpException(listResponse)
            }
            val r = listResponse.body().mounts
            Utilities.nullCheck(r)
            r
        }.singleElement().toObservable()
}