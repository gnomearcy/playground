package eu.toma.dev.playground.warcraft.bosses;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.toma.dev.playground.R;

/**
* Adapter is responsible for:
 * - filtering and sorting
*/
public class BossAdapter extends RecyclerView.Adapter<BossAdapter.BossHolder>
{
    @Override
    public BossHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType)
    {
        return null;
    }

    /**
     * Inflate XML here.
     */
    @Override
    public void onBindViewHolder(BossHolder holder,
                                 int position)
    {

    }


    @Override
    public int getItemCount()
    {
        return 0;
    }

    public static final class BossHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.boss_image)
        protected ImageView image;
        @BindView(R.id.boss_name)
        protected TextView name;
        @BindView(R.id.boss_health)
        protected TextView health;

        public BossHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
