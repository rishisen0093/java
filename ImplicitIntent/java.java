package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnClickBrowser(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://amazon.com"));
        startActivity(i);
    }public void OnClickMakeCalls(View view){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+91 9372564362"));
        startActivity(i);
    }public void OnClickMap(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.827500,-122.481670"));
        startActivity(i);
    }

}