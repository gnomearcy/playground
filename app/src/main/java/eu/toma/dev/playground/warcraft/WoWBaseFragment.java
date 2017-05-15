package eu.toma.dev.playground.warcraft;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import eu.toma.dev.playground.HasComponent;
import eu.toma.dev.playground.warcraft.di.WoWcomponent;

/**
* Base adapter for all WoW Fragments
*/
public class WoWBaseFragment extends Fragment implements HasComponent<WoWcomponent>
{
    @NonNull
    @Override
    public WoWcomponent getComponent()
    {
        return ((WarcraftActivity)getActivity()).getComponent();
    }
}