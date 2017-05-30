package warcraft.mounts.all

import javax.inject.Inject

import io.reactivex.Observable
import warcraft.Presenter
import warcraft.mounts.MountService
import warcraft.mounts.Mount
import warcraft.mounts.di.Mounts

@Mounts
class AllMountsPresenter
@Inject
constructor(private val service: MountService) : Presenter<MVP.View>(), MVP.Presenter {

    override fun getMounts() {
        val mounts = service.mounts
    }
}
