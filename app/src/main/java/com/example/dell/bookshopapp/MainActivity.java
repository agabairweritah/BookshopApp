package com.example.dell.bookshopapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;

    //AGABAIRWE RITAH

    //2017/BIT/052/PS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.button);
    }
    void setfragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }

    @Override
    public void onRestart(){
        super.onRestart();
    }
    @Override
    public void onStart() {
        super.onStart();
    }
    @Override
    public void onResume() {
        super.onResume();
    }


    public void button(View view) {
        Intent mintent = new Intent(MainActivity.this, Login.class);
        startActivity(mintent);
    }

    public void button2(View view) {
        Intent mintent = new Intent(MainActivity.this, Signup.class);
        startActivity(mintent);

    }



    public void button4(View view) {
        Intent mintent = new Intent(MainActivity.this, books.class);
        startActivity(mintent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        getMenuInflater().inflate(R.menu.item,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int x=item.getItemId();

        switch (x){
            case R.id.list:
               Intent n=new Intent(getApplicationContext(),stock.class);
               startActivity(n);
            return true;

            case R.id.home:
                setfragment(new Home());
                break;
            case R.id.settings:
                setfragment(new Settings());
                break;

        }
        return super.onOptionsItemSelected(item);
    }


        public void show(View view) {
            Toast toasttop = Toast.makeText(MainActivity.this, "Welcome to Arsitoc Book shop", Toast.LENGTH_SHORT);
            toasttop.setGravity(Gravity.TOP,0,0);
            toasttop.show();
            Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
            implicitIntent.setData(Uri.parse("http://aristocbooklexltd.tradenote.net/"));
            startActivity(implicitIntent);
        }


}
