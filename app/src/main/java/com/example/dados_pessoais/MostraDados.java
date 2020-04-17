package com.example.dados_pessoais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.Toast;

public class MostraDados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_dados);

        Intent intent = getIntent();

        String name = intent.getStringExtra(MainActivity.EXTRA_NOME);
        TextView textViewName = findViewById(R.id.textViewName);
        //textViewName.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);// nao funciona
        String beforName = "Name: "+ name;// passar o resultado do campo mais o indicador numa string
        SpannableString ss = new SpannableString(beforName);
        ForegroundColorSpan cBlack = new ForegroundColorSpan(Color.BLACK);
        int x = beforName.indexOf(":")+1;//forma para saber o index dos :
        ss.setSpan(cBlack,0, x, Spanned.SPAN_INCLUSIVE_INCLUSIVE);/*defenir o intervalo a
        alterar a cor na string*/
        textViewName.setText(ss);

        String phone = intent.getStringExtra(MainActivity.EXTRA_PHONE);
        TextView textViewPhone = findViewById(R.id.textViewPhone);
        String beforPone = "Phone: " + phone;
        SpannableString ss1 = new SpannableString(beforPone);
        //ForegroundColorSpan cBlack1 = new ForegroundColorSpan(Color.BLACK);
        int y = beforPone.indexOf(":")+1;
        ss1.setSpan(cBlack,0,y, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        textViewPhone.setText(ss1);

        String email = intent.getStringExtra(MainActivity.EXTRA_EMAIL);
        TextView textViewEmail = findViewById(R.id.textViewEmail);
        String beforEmail = "E-mail: " + email;
        SpannableString ss2 = new SpannableString(beforEmail);
        //ForegroundColorSpan cBlack2 = new ForegroundColorSpan(Color.BLACK);
        int z = beforEmail.indexOf(":")+1;
        ss2.setSpan(cBlack,0, z, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        textViewEmail.setText(ss2);

        int age = intent.getIntExtra(MainActivity.EXTRA_AGE, 1);
        TextView textViewAge = findViewById(R.id.textViewAge);
        String beforAge = "Age: " + age;
        SpannableString ss3 = new SpannableString(beforAge);
        //ForegroundColorSpan cBlack3 = new ForegroundColorSpan(Color.BLACK);
        int c = beforAge.indexOf(":")+1;
        ss3.setSpan(cBlack,0,c, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        textViewAge.setText(ss3);

        String weight = intent.getStringExtra(MainActivity.EXTRA_WEIGHT);
        TextView textViewWeight = findViewById(R.id.textViewWeight);
        String beforWeight = "Weight: " + weight + " Kg";
        SpannableString ss4 = new SpannableString(beforWeight);
        //ForegroundColorSpan cBlack4 = new ForegroundColorSpan(Color.BLACK);
        int v = beforWeight.indexOf(":")+1;
        ss4.setSpan(cBlack,0, v, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        textViewWeight.setText(ss4);

        String height = intent.getStringExtra(MainActivity.EXTRA_HEIGHT);
        TextView textViewHeight = findViewById(R.id.textViewHeight);
        String beforHeight = "Height: " + height + " Meters";
        SpannableString ss5 = new SpannableString(beforHeight);
        //ForegroundColorSpan cBlack5 = new ForegroundColorSpan(Color.BLACK);
        int b = beforHeight.indexOf(":")+1;
        ss5.setSpan(cBlack,0, b, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        textViewHeight.setText(ss5);
        Toast.makeText(this, "Dados Pessoais\n"+ name, Toast.LENGTH_SHORT).show(); // Mensagem informativa


    }
}
