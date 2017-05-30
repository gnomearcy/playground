package warcraft

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import eu.toma.dev.playground.HasComponent
import eu.toma.dev.playground.R
import eu.toma.dev.playground.warcraft.di.DaggerWoWcomponent
import warcraft.di.WoWcomponent

class WarcraftActivity : AppCompatActivity(), HasComponent<WoWcomponent> {
    private var component: WoWcomponent? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warcraft)
    }

    override fun getComponent(): WoWcomponent {
        return DaggerWoWcomponent.create()
    }

    open fun releaseObjects() {component = null;}
}
