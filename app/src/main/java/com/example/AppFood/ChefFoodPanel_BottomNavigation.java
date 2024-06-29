package com.example.AppFood;

import static com.example.AppFood.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.AppFood.chefFodpanel.ChefHomeFragment;
import com.example.AppFood.chefFodpanel.ChefOrderFragment;
import com.example.AppFood.chefFodpanel.ChefPendingOrderFragment;
import com.example.AppFood.chefFodpanel.ChefProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ChefFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chef_food_panel_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.chef_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        if (item.getItemId() == R.id.chefHome) {
            fragment = new ChefHomeFragment();
        } else if (item.getItemId() == R.id.PendingOrders) {
            fragment = new ChefPendingOrderFragment();
        } else if (item.getItemId() == R.id.Orders) {
            fragment = new ChefOrderFragment();
        } else if (item.getItemId() == R.id.chefProfile) {
            fragment = new ChefProfileFragment();
        }

        return loadcheffragment(fragment);
    }

    private boolean loadcheffragment(Fragment fragment) {

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
            return true;
        }
        return false;
    }
}
