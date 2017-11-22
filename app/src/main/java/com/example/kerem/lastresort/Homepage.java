package com.example.kerem.lastresort;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {

    Button logout, openurl, openloc, share;
    EditText url, location, shareedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        this.setTitle("Implicit Intents");

        url = (EditText) findViewById(R.id.urlid);
        location = (EditText) findViewById(R.id.locationtxtid);
        shareedit = (EditText) findViewById(R.id.sharetxtid);
        openurl = (Button) findViewById(R.id.openurlid);
        openurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urltxt = url.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://" + urltxt));
                startActivity(i);
                url.setText("");
            }
        });

        openloc = (Button) findViewById(R.id.openlocid);
        openloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locationtxt = location.getText().toString();
                String uri = "geo:0,0?q=" + locationtxt;
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
                location.setText("");
            }
        });


        share = (Button) findViewById(R.id.shareid);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sharetxt = shareedit.getText().toString();
                Uri SMS_URI = Uri.parse("smsto:"); //Replace the phone number
                Intent sms = new Intent(Intent.ACTION_VIEW, SMS_URI);
                sms.putExtra("sms_body", sharetxt); //Replace the message witha a vairable
                startActivity(sms);
                shareedit.setText("");
            }
        });


        logout = (Button) findViewById(R.id.logoutid);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();
            }
        });

    }
}
