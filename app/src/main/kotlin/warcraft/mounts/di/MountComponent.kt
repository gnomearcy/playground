package warcraft.mounts.di

import dagger.Component
import warcraft.di.WoWcomponent
import warcraft.mounts.MountsActivity
import warcraft.mounts.all.AllMountsFragment
import warcraft.mounts.details.MountDetailsFragment

@Mounts
@Component(dependencies = arrayOf(WoWcomponent::class))
interface MountComponent {
    fun inject(allMounts: AllMountsFragment)

    fun inject(mountDetailsFragment: MountDetailsFragment)

    fun inject(mountsActivity: MountsActivity)
}
