package com.example.portfolio;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    SkillFragment skillFragment = new SkillFragment();
    HobbiesFragment hobbiesFragment = new HobbiesFragment();
    ContactFragment contactFragment = new ContactFragment();











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
            return true;
        }else if(item.getItemId() == R.id.profile){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
            return true;
        }else if(item.getItemId() == R.id.skill){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, skillFragment).commit();
            return true;
        }else if(item.getItemId() == R.id.hobbies){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, hobbiesFragment).commit();
            return true;
        }else if(item.getItemId() == R.id.contact) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, contactFragment).commit();
            return true;
        }else {
            return false;
        }
    }
}
