package warcraft.bosses

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import butterknife.BindView
import butterknife.ButterKnife
import eu.toma.dev.playground.R

/**
 * Adapter is responsible for:
 * - filtering and sorting
 */
class BossAdapter : RecyclerView.Adapter<BossAdapter.BossHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): BossHolder? {
        return null
    }

    /**
     * Inflate XML here.
     */
    override fun onBindViewHolder(holder: BossHolder,
                                  position: Int) {

    }


    override fun getItemCount(): Int {
        return 0
    }

    class BossHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.boss_image)
        protected lateinit var image: ImageView
        @BindView(R.id.boss_name)
        protected lateinit var name: TextView
        @BindView(R.id.boss_health)
        protected lateinit var health: TextView

        // TODO what is init keyword?
        init {
            ButterKnife.bind(this, itemView)
        }
    }
}
