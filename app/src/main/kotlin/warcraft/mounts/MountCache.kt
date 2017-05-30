package warcraft.mounts

import javax.inject.Inject

import io.reactivex.Observable

@warcraft.mounts.di.Mounts
class MountCache

@Inject
constructor()
{
    private var cachedMounts: List<Mount>? = null

    fun getCachedMounts(): Observable<List<Mount>> {
        if (cachedMounts != null) {
            return Observable.fromIterable(cachedMounts).toList().toObservable()
        } else {
            return Observable.error<List<Mount>>(Exception("no cached mounts available"))
        }
    }

    fun save(mounts: List<Mount>) {
        this.cachedMounts = mounts
    }
}
