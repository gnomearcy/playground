package warcraft.mounts

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup

import butterknife.BindView
import eu.toma.dev.playground.HasComponent
import eu.toma.dev.playground.R
import eu.toma.dev.playground.warcraft.mounts.di.DaggerMountComponent
import warcraft.di.WoWcomponent
import warcraft.mounts.all.AllMountsFragment
import warcraft.mounts.di.MountComponent

/**
 * @see MountComponent

 * @see WoWcomponent
 */
class MountsActivity : AppCompatActivity(), HasComponent<MountComponent> {
    private var component: MountComponent? = null

    @BindView(R.id.mount_container)
    protected var container: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mounts)
        val fm = supportFragmentManager
        var f: AllMountsFragment? = fm.findFragmentByTag(AllMountsFragment::class.java.canonicalName) as AllMountsFragment
        if (f == null) {
            f = AllMountsFragment()
        }
        fm.beginTransaction().add(R.id.mount_container, f, AllMountsFragment::class.java.canonicalName).commit()
    }

    override fun getComponent(): MountComponent {
        if (component == null) {
            component = DaggerMountComponent.create()
        }
        return component
    }

    override fun onPause() {
        super.onPause()
        component = null
    }
}
