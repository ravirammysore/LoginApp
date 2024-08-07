package com.rkr.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    private SharedPreferences sp;
    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username_edittext);
        passwordEditText = findViewById(R.id.password_edittext);
        Button loginButton = findViewById(R.id.login_button);

        // Load saved username when the app starts
        sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String savedUsername = sp.getString(KEY_USERNAME, "");
        usernameEditText.setText(savedUsername);

        loginButton.setOnClickListener(view -> {
            var userName = usernameEditText.getText().toString();
            var password = passwordEditText.getText().toString();

            if(userName.equals("ravi") && password.equals("123")){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

                var editor = sp.edit();
                editor.putString(KEY_USERNAME, userName);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("USERNAME", userName);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);

                finish();
            }
            else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}