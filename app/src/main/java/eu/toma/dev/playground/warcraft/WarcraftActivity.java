package eu.toma.dev.playground.warcraft;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import eu.toma.dev.playground.HasComponent;
import eu.toma.dev.playground.R;
import eu.toma.dev.playground.warcraft.di.DaggerWoWcomponent;
import eu.toma.dev.playground.warcraft.di.WoWcomponent;

public class WarcraftActivity extends AppCompatActivity implements HasComponent<WoWcomponent>
{
    private WoWcomponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warcraft);
    }

    @NonNull
    @Override
    public WoWcomponent getComponent()
    {
        return DaggerWoWcomponent.create();
    }
}
