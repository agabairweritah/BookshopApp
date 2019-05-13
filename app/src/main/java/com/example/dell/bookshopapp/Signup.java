package com.example.dell.bookshopapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
private EditText txt1,txt2,txt4;
private   Button  btn1;
private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setupUIViews();
firebaseAuth = FirebaseAuth.getInstance();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    // upload to database
                        String email = txt2.getText().toString().trim();
                    //String email = txt2.getText().toString().trim();
                    //String phone = txt3.getText().toString().trim();
                    String password = txt4.getText().toString().trim();

                    Task<AuthResult> authResultTask = firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                            Toast.makeText(Signup.this, "Registration sucessfull",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Signup.this, Login.class));
                        }else {
                                Toast.makeText(Signup.this, "Registration sucessfull",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Signup.this, Login.class));
                            }
                        }
                    });

                }
            }
        });


    }
    private void setupUIViews(){
        txt1=findViewById(R.id.editText3);
        txt2=findViewById(R.id.editText4);
        //txt3=findViewById(R.id.editText4);
        txt4=findViewById(R.id.editText5);
        btn1=findViewById(R.id.button8);
        }
        private boolean validate(){
        Boolean result = false;
        String txt = txt1.getText().toString();
            String tx = txt2.getText().toString();
            //String txr = txt3.getText().toString();
            String txrr = txt4.getText().toString();
            if(txt.isEmpty() || tx.isEmpty() || txrr.isEmpty()){
                Toast.makeText(this,"Please enter all the details",Toast.LENGTH_SHORT).show();
            }else {
                result = true;
            }
        return result;
        }


}
