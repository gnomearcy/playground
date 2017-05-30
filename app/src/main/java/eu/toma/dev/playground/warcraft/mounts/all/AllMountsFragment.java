package eu.toma.dev.playground.warcraft.mounts.all;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.toma.dev.playground.R;
import eu.toma.dev.playground.warcraft.WoWBaseFragment;
import eu.toma.dev.playground.warcraft.mounts.Mount;

public class AllMountsFragment extends WoWBaseFragment implements MVP.View
{
    @BindView(R.id.mounts_recycler)
    protected RecyclerView recycler;
    private LinearLayoutManager linearManager;
    private RecyclerView.Adapter adapter;

    private static final int GRID_COLUMNS = 2;
    private GridLayoutManager gridManager;

    @Inject
    protected AllMountsPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.all_mounts, container, false);
        ButterKnife.bind(this, view);
        recycler.setLayoutManager(getLinearManager(container.getContext()));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    private LinearLayoutManager getLinearManager(Context c){
        if(linearManager == null){
            linearManager = new LinearLayoutManager(c);
        }
        return linearManager;
    }

    private GridLayoutManager getGridManager(Context c){
        if(gridManager == null){
            gridManager = new GridLayoutManager(c, GRID_COLUMNS);
        }
        return gridManager;
    }

    @Override
    public void onMounts(List<Mount> newMounts)
    {

    }

    @Override
    public void onMountsFetchError()
    {

    }

    @Override
    public void onNoMounts()
    {

    }

    @Override
    public void showLoading()
    {

    }

    @Override
    public void hideLoading()
    {

    }

    @Override
    public void showContent()
    {

    }

    @Override
    public void hideContent()
    {

    }
}
