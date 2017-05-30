package warcraft.mounts

import javax.inject.Inject

import io.reactivex.Observable

@warcraft.mounts.di.Mounts
class MountDb
@Inject
constructor() {
    private var mounts: List<Mount>? = null

    fun mountsFromDb(): Observable<List<Mount>> {
        if (mounts == null) {
            return Observable.error<List<Mount>>(Exception("db null mounts"))
        } else {
            return Observable.fromIterable(mounts).toList().toObservable()
        }
    }

    fun save(mounts: List<Mount>) {
        this.mounts = mounts
    }
}
