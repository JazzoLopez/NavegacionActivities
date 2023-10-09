package com.example.navegacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
private TextView tvUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvUsername= findViewById(R.id.tv_username);
        Bundle parametersReceived = getIntent().getExtras(); //Extras para recuperar
        tvUsername.setText(parametersReceived.getString("username")); //Recuperamos y solicita la llave.
    }
}