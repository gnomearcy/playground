package warcraft.bosses

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import butterknife.BindView
import butterknife.ButterKnife
import eu.toma.dev.playground.R
import eu.toma.dev.playground.warcraft.WoWBaseFragment

class BossesFragment : WoWBaseFragment() {
    @BindView(R.id.recycler_view)
    protected var list: RecyclerView
    protected var manager: LinearLayoutManager

    fun onCreateView(inflater: LayoutInflater,
                     container: ViewGroup?,
                     savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_bosses, container, false)
        ButterKnife.bind(this, view)
        list.setHasFixedSize(true)
        manager = LinearLayoutManager(container?.context)
        list.layoutManager = manager
        return view
    }
}
