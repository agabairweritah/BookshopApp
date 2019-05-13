package com.example.dell.bookshopapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Frag_bottom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_bottom);

        BottomNavigationView bottomnavg=findViewById(R.id.navigation);
        bottomnavg.setOnNavigationItemSelectedListener(navlistener);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new Home_fragment()).commit();
    }
 private BottomNavigationView.OnNavigationItemSelectedListener navlistener=new
         BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 Fragment selectedFragment=null;
                 switch (item.getItemId()){
                     case R.id.nav_home:
                         selectedFragment=new Home_fragment();
                         break;
                     case R.id.nav_images:
                         selectedFragment=new Image_fragment();
                         break;
                     case R.id.nav_comment:
                         selectedFragment=new comment_fragment();
                         break;
                 }
                 getSupportFragmentManager().beginTransaction().replace(R.id.container,selectedFragment).
                         commit();
                 return  true;
             }
         };
}
