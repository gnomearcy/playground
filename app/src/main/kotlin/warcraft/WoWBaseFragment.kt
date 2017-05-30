package warcraft

import android.os.Bundle
import android.support.v4.app.Fragment

import eu.toma.dev.playground.HasComponent
import warcraft.di.WoWcomponent

/**
 * Base class for all WoW Fragments
 */
open class WoWBaseFragment : Fragment(), HasComponent<WoWcomponent> {
    override fun getComponent(): WoWcomponent {
        return (activity as WarcraftActivity).component
    }

    open fun onActivityCreatedDelegate(savedInstanceState: Bundle?){
        // Override in subclass
    }

    override final fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Perform cast to see if the fragment is attached to wrong activity
        activity as WarcraftActivity
        onActivityCreatedDelegate(savedInstanceState)
    }
}