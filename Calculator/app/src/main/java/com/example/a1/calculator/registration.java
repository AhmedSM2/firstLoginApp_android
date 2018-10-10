package com.example.a1.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {
    DB_App db = new DB_App(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void sign_up(View view) {
        String t1,t2,t3,t4;
        t1 = ( (EditText) findViewById(R.id.fname) ).getText().toString().trim();
        t2 = ( (EditText) findViewById(R.id.Lname) ).getText().toString().trim();
        t3 = ( (EditText) findViewById(R.id.mail) ).getText().toString().trim();
        t4 = ( (EditText) findViewById(R.id.pass) ).getText().toString().trim();
        if(t1.length()==0 || t2.length()==0 || t3.length()==0 || t4.length()==0){
            Toast.makeText(getApplicationContext(), "please fill all fields !", Toast.LENGTH_LONG).show();
        }
        else {
               //startActivity(LoginScreen);
            boolean check =db.insertData(t1,t2,t3,t4);
            if(!check){
                Toast.makeText(getApplicationContext(), "not saved yet !", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Done !", Toast.LENGTH_LONG).show();
                Intent login = new Intent(this,MainActivity.class);
                startActivity(login);
            }
        }

    }
}
