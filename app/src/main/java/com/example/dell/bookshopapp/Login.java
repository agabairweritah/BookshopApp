package com.example.dell.bookshopapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    DatabaseHelper mydb;
EditText txt1,txt2,txt3;
Button  btn1, btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mydb=new DatabaseHelper(this);

        txt1=findViewById(R.id.editText);
        txt2=findViewById(R.id.editText2);
        txt3=findViewById(R.id.editText6);
        btn1=findViewById(R.id.button6);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=txt1.getText().toString();
                String s2=txt2.getText().toString();
                String s3=txt3.getText().toString();
                if(s.equals("")||s2.equals("")    ||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"please fill in the required fields to continue",Toast.LENGTH_LONG).show();
                }
                else{
                    if(s2.equals(s3)){
                        Boolean chkusername=mydb.chkusername(s);
                        if (chkusername==true){
                            Boolean insert=mydb.insert(s,s2);
                            Intent myintent= new Intent(Login.this,books.class);
                            startActivity(myintent);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"registered successfully",Toast.LENGTH_LONG).show();
                            }
                        }
                    }else  {
                        if(s2!=s3)
                        Toast.makeText(getApplicationContext(), "password doesnot much", Toast.LENGTH_LONG).show();

                        Intent myintent= new Intent(Login.this,Login.class);
                        startActivity(myintent);
                    }
                }
            }
        });
    }


}
