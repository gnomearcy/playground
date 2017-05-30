package warcraft.mounts.all

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import javax.inject.Inject

import butterknife.BindView
import butterknife.ButterKnife
import eu.toma.dev.playground.R
import warcraft.WoWBaseFragment
import warcraft.extensions.inflate
import warcraft.mounts.Mount

import kotlinx.android.synthetic.main.all_mounts.*

class AllMountsFragment : WoWBaseFragment(), MVP.View
{
    companion object {

        private val GRID_COLUMNS = 2
    }


    private var recycler by lazy {
        mounts_recycler.setHasFixedSize(true)
        mounts_recycler.layoutManager = LinearLayoutManager(context)
        mounts_recycler
    }

    private lateinit var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>

    private var linearManager: LinearLayoutManager? = null
    private var gridManager: GridLayoutManager? = null

    @Inject
    protected lateinit var presenter: AllMountsPresenter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.all_mounts) as View
        //        ButterKnife.bind(this, view)
        return view
    }

    override fun onActivityCreatedDelegate(savedInstanceState: Bundle?) {
        super.onActivityCreatedDelegate(savedInstanceState)
        mounts_recycler.setHasFixedSize(true)
        mounts_recycler.layoutManager = LinearLayoutManager(context);
    }

    private fun getLinearManager(c: Context): LinearLayoutManager {
        if (linearManager == null) {
            linearManager = LinearLayoutManager(c)
        }
        return linearManager as LinearLayoutManager
    }

    private fun getGridManager(c: Context): GridLayoutManager {
        if (gridManager == null) {
            gridManager = GridLayoutManager(c, GRID_COLUMNS)
        }
        return gridManager as GridLayoutManager
    }

    override fun onMounts(newMounts: List<Mount>) {

    }

    override fun onMountsFetchError() {

    }

    override fun onNoMounts() {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showContent() {

    }

    override fun hideContent() {

    }

}

