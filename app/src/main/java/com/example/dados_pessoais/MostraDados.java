package com.example.dados_pessoais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MostraDados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_dados);

        Intent intent = getIntent();

        String name = intent.getStringExtra(MainActivity.EXTRA_NOME);
        TextView textViewName = findViewById(R.id.textViewName);
        textViewName.setText(name);

        String phone = intent.getStringExtra(MainActivity.EXTRA_PHONE);
        TextView textViewPhone = findViewById(R.id.textViewPhone);
        textViewPhone.setText(phone);

        String email = intent.getStringExtra(MainActivity.EXTRA_EMAIL);
        TextView textViewEmail = findViewById(R.id.textViewEmail);
        textViewEmail.setText(email);

        String age = intent.getStringExtra(MainActivity.EXTRA_AGE);
        TextView textViewAge = findViewById(R.id.textViewAge);
        textViewAge.setText(age);

        String weight = intent.getStringExtra(MainActivity.EXTRA_WEIGHT);
        TextView textViewWeight = findViewById(R.id.textViewWeight);
        textViewWeight.setText(weight);

        String height = intent.getStringExtra(MainActivity.EXTRA_HEIGHT);
        TextView textViewHeight = findViewById(R.id.textViewHeight);
        textViewHeight.setText(height);

    }
}
