package eu.toma.dev.playground.warcraft.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.toma.dev.playground.R;
import eu.toma.dev.playground.warcraft.WoWBaseFragment;

public class BossesFragment extends WoWBaseFragment
{
    @BindView(R.id.recycler_view)
    protected RecyclerView list;
    protected LinearLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_bosses, container, false);
        ButterKnife.bind(this, view);
        list.setHasFixedSize(true);
        manager = new LinearLayoutManager(container == null ? null : container.getContext());
        list.setLayoutManager(manager);
        return view;
    }
}
