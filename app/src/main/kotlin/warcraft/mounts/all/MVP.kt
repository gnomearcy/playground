package warcraft.mounts.all

import warcraft.mounts.Mount

interface MVP {
    interface View {
        fun onMounts(newMounts: List<Mount>)

        fun onMountsFetchError()

        fun onNoMounts()

        fun showLoading()

        fun hideLoading()

        fun showContent()

        fun hideContent()
    }

    interface Presenter {
        fun getMounts()
    }
}
