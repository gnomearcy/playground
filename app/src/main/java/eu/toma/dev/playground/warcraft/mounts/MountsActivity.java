package eu.toma.dev.playground.warcraft.mounts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import butterknife.BindView;
import eu.toma.dev.playground.HasComponent;
import eu.toma.dev.playground.R;
import eu.toma.dev.playground.warcraft.mounts.all.AllMountsFragment;
import eu.toma.dev.playground.warcraft.mounts.di.DaggerMountComponent;
import eu.toma.dev.playground.warcraft.mounts.di.MountComponent;
import eu.toma.dev.playground.warcraft.di.WoWcomponent;

/**
 * @see MountComponent
 * @see WoWcomponent
*/
public class MountsActivity extends AppCompatActivity implements HasComponent<MountComponent>
{
    private MountComponent component;

    @BindView(R.id.mount_container)
    protected ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mounts);
        FragmentManager fm = getSupportFragmentManager();
        AllMountsFragment f = (AllMountsFragment) fm.findFragmentByTag(AllMountsFragment.class.getCanonicalName());
        if(f == null){
            f = new AllMountsFragment();
        }
        fm.beginTransaction().add(R.id.mount_container, f, AllMountsFragment.class.getCanonicalName()).commit();
    }

    @NonNull
    @Override
    public MountComponent getComponent()
    {
        if(component == null){
            component = DaggerMountComponent.create();
        }
        return component;
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        component = null;
    }
}
