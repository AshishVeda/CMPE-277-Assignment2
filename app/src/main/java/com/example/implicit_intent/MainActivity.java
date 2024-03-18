package com.example.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;

import android.util.Log;
import android.widget.EditText;

import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    EditText urlEditText, phoneEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlEditText = findViewById(R.id.urlEditText);
        phoneEditText = findViewById(R.id.editTextPhone2);
        Button openUrlButton = findViewById(R.id.openUrlButton);
        openUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlEditText.getText().toString();
                openUrl(url);
            }
        });

        Button makeCallButton = findViewById(R.id.makeCallButton);
        makeCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneEditText.getText().toString();
                makeCall(phoneNumber);
            }
        });
    }

    private void openUrl(String url) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void makeCall(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    public void closeApp(View view) {
        Log.e("tag","Here");
        MainActivity.this.finish();
    }
}