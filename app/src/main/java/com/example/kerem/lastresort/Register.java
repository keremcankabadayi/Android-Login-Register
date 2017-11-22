package com.example.kerem.lastresort;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Button register;
    EditText namsur, email, password, age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        namsur = (EditText) findViewById(R.id.inputnamsur);
        email = (EditText) findViewById(R.id.inputemail);
        age = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.inputpass);

        register = (Button) findViewById(R.id.registerbtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shf = getSharedPreferences("userInfo", MODE_PRIVATE);
                String inputname = namsur.getText().toString();
                String inputemail = email.getText().toString();
                String inputpass = password.getText().toString();

                if((inputname.isEmpty()) && (inputemail.isEmpty())){
                    Toast.makeText(Register.this, "You can skip only Password!", Toast.LENGTH_LONG).show();
                } else {

                SharedPreferences.Editor editor = shf.edit();
                editor.putString("name", inputname);
                editor.putString("email", inputemail);
                editor.putString("pass", inputpass);
                editor.commit();
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();
                }

            }
        });
    }
}
