package com.rkr.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username_edittext);
        passwordEditText = findViewById(R.id.password_edittext);
        Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(view -> {
            var userName = usernameEditText.getText().toString();
            var password = passwordEditText.getText().toString();

            if(userName.equals("ravi") && password.equals("123")){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("USERNAME", userName);

                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}