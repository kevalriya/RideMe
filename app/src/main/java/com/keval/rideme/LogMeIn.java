package com.keval.rideme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class LogMeIn extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void LogIn(View v) {
        String s = "login";
        EditText emailText = findViewById(R.id.emailText);
        EditText passwordText = findViewById(R.id.passwordText);
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        new authenticatingAsyncTask(this).execute(s, email, password);
    }

    public void changeIntent(View v) {
        Intent i = new Intent(this, SignMeUp.class);
        startActivity(i);
        finish();
    }

}