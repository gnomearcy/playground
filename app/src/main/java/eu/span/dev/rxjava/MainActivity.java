package eu.span.dev.rxjava;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.span.dev.rxjava.github.GithubActivity;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @BindView(R.id.navigation_view)
    protected NavigationView navigationView;
    @BindView(R.id.drawer)
    protected DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        navigation();
        ActionBarDrawerToggle actionBarDrawerToggle = actionbarToggle();
        drawer.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void navigation()
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                // Toggle checking
                item.setChecked(!item.isChecked());

                drawer.closeDrawers();

                switch(item.getItemId())
                {
                    case R.id.drawer_github:
                        GithubActivity.start(MainActivity.this);
                        break;
                    case R.id.drawer_ui_1:
                        Toast.makeText(MainActivity.this, "clicked ui 1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_ui_2:
                        Toast.makeText(MainActivity.this,
                                       "clicked ui 2",
                                       Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });
    }

    private ActionBarDrawerToggle actionbarToggle(){
        return new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer){
            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
            }
        };
    }
}
