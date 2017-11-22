package com.example.kerem.lastresort;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button register, login;
    EditText mail, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mail = (EditText) findViewById(R.id.mailinput);
        password = (EditText) findViewById(R.id.passinput);

        SharedPreferences shf = getSharedPreferences("userInfo", MODE_PRIVATE);
        String getemail = shf.getString("email", "");
        String getpass = shf.getString("pass", "");


        if((!getemail.isEmpty()) || (!getpass.isEmpty())){
        mail.setText(getemail);
        password.setText(getpass);
        }

        login = (Button) findViewById(R.id.loginbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences shf = getSharedPreferences("userInfo", MODE_PRIVATE);
                String getemail = shf.getString("email", "");
                String getpass = shf.getString("pass", "");

                String emailtxt = mail.getText().toString();
                String passtxt = password.getText().toString();


                if ((emailtxt.isEmpty()) && (passtxt.isEmpty())){
                    Toast.makeText(Login.this, "Please enter your login informations!", Toast.LENGTH_SHORT).show();
                }
                else if ((!getemail.matches(emailtxt) || (!getpass.matches(passtxt)))) {
                        Toast.makeText(Login.this, "Please check your E-mail and Password!", Toast.LENGTH_SHORT).show();
                }
                else if ((getemail.matches(emailtxt)) && (getpass.matches(passtxt))){
                    Intent i = new Intent(getApplicationContext(), Homepage.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Login.this, "Login Succeeded!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        register = (Button) findViewById(R.id.registerbtn);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);

            }
        });

    }
}
