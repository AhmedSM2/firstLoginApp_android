package com.example.a1.calculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    /*    final EditText txt1, txt2, txt3;
        Button btn;
        txt1 = (EditText) findViewById(R.id.uName);
        txt2 = (EditText) findViewById(R.id.mail);
        final Intent screen3 = new Intent(this, Admin.class);
        btn = (Button) findViewById(R.id.btn2);
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = getApplicationContext();
                    CharSequence text ="";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast;
                    String p=txt2.getText().toString();
                    if (txt1.getText().toString().length() ==0 && txt2.getText().toString().length() ==0) {
                        text = "there are an input/s is null!";
                        toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else if(txt1.getText().toString().equals("a2020") && p.equalsIgnoreCase("aaa")){
                        startActivity(screen3);
                    }
                    else {
                        txt1.setText(txt2.getText().toString());
                        text = "there are something occured!";
                        toast = Toast.makeText(context, text, duration);
                        toast.show();

                    }
                }
            });
        }
        */
    }

    public void register(View view) {
        Intent regsForm = new Intent(this,registration.class);
        startActivity(regsForm);
    }

    public void login(View view) {
        DB_App db = new DB_App(this);
        final EditText txt1, txt2;
        txt1 = (EditText) findViewById(R.id.mail);
        txt2 = (EditText) findViewById(R.id.password);
        String email = txt1.getText().toString() , pass = txt2.getText().toString();
        final Intent screen3 = new Intent(this, Admin.class);
        Context context = getApplicationContext();
        CharSequence text ="";
        int duration = Toast.LENGTH_SHORT;
        Toast toast;
        if (email.length() ==0 && pass.length() ==0) {
            text = "there are an input/s is null!";
            toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if(db.getOneRow(email,pass)>0){
            startActivity(screen3);
        }
        else {
            //txt1.setText(txt2.getText().toString());
            text = "there are something occured!";
            toast = Toast.makeText(context, text, duration);
            toast.show();

        }
    }
}