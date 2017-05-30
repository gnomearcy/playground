import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast

import butterknife.BindView
import butterknife.ButterKnife
import eu.toma.dev.playground.R
import eu.toma.dev.playground.github.GithubActivity

class MainActivity : AppCompatActivity()
{
    @BindView(R.id.toolbar)
    protected lateinit var toolbar: Toolbar
    @BindView(R.id.navigation_view)
    protected lateinit var navigationView: NavigationView
    @BindView(R.id.drawer)
    protected lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)
        setSupportActionBar(toolbar)
        navigation()
        val actionBarDrawerToggle = actionbarToggle()
        drawer.setDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

    private fun navigation() {
        navigationView.setNavigationItemSelectedListener { item ->
            // Toggle checking
            item.isChecked = !item.isChecked

            drawer.closeDrawers()

            when (item.itemId) {
                R.id.drawer_github -> GithubActivity.start(this@MainActivity)
                R.id.drawer_ui_1 -> Toast.makeText(this@MainActivity, "clicked ui 1", Toast.LENGTH_SHORT).show()
                R.id.drawer_ui_2 -> Toast.makeText(this@MainActivity,
                        "clicked ui 2",
                        Toast.LENGTH_SHORT).show()
            }

            false
        }
    }

    private fun actionbarToggle(): ActionBarDrawerToggle {
        return object : ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer) {
            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
            }

            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
            }
        }
    }
}
