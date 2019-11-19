package com.besha.v13;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavController navController;
    VitaminViewModel model;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = ViewModelProviders.of(this, new VitaminViewModel.VitaminModelProvider(this)).get(VitaminViewModel.class);

        Toolbar toolbar = findViewById(R.id.mytoolbar);
        navController = Navigation.findNavController(this, R.id.fragment2);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.mydrawer);
        drawerLayout.requestLayout();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setDrawerLayout(drawerLayout)
                .build();
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // can replace menu by inflate another one
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.share:
                String txt = "http://www.google.com";
                String mimeType = "text/plain";
                ShareCompat.IntentBuilder.from(this).setType(mimeType)
                        .setText(txt)
                        .startChooser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.about:
                navController.navigate(R.id.about);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.contact:
                navController.navigate(R.id.contact);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            default:
                return NavigationUI.onNavDestinationSelected(menuItem, navController);
        }

    }
}
