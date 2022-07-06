package com.example.ummauniversityapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity    {

    BottomNavigationView bottomNavigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();


    main home = new main();
    Newsfeed newsfeed = new Newsfeed();
    Faculty faculty = new Faculty();
    Image image = new Image();
    Aboutus aboutus = new Aboutus();
    Images images = new Images();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final FragmentManager fragmentManager = getSupportFragmentManager();


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        fragmentManager.beginTransaction().replace(R.id.container,home).commit();

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,home).commit();
                        return  true;
                    case R.id.gallery:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,images).commit();
                        return  true;
                    case R.id.faculty:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,faculty).commit();
                        return  true;
                    case R.id.newsfeed:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,newsfeed).commit();
                        return  true;
                    case R.id.aboutus:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,aboutus).commit();
                        return  true;
                }
                return  false;

            }
        });






    }


    
}