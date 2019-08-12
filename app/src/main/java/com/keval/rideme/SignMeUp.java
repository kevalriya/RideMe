package com.keval.rideme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class SignMeUp extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void signup(View v) {
        String s = "signup";
        EditText fnText = findViewById(R.id.fnText);
        EditText lnText = findViewById(R.id.lnText);
        EditText emailText = findViewById(R.id.emailText);
        EditText passwordText = findViewById(R.id.passwordText);
        String firstName = fnText.getText().toString();
        String lastName = lnText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        new authenticatingAsyncTask(this).execute(s,firstName, lastName, email, password);
    }

}