package com.example.dados_pessoais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NOME = "com.exemple.dados_pessoais.NAME";
    public static final String EXTRA_PHONE = "com.exemple.dados_pessoais.PHONE";
    public static final String EXTRA_EMAIL = "com.exemple.dados_pessoais.EMAIL";
    public static final String EXTRA_AGE = "com.exemple.dados_pessoais.AGE";
    public static final String EXTRA_WEIGHT =  "com.exemple.dados_pessoais.WEIGHT";
    public static final String EXTRA_HEIGHT =  "com.exemple.dados_pessoais.HEIGHT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendData(View view) {
        Intent intent = new Intent(this, MostraDados.class);

        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        String name = editTextName.getText().toString();

        EditText editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        String phone = editTextPhone.getText().toString();

        EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        String email = editTextEmail.getText().toString();

        EditText editTextAge = (EditText) findViewById(R.id.editTextAge);
        String age = editTextAge.getText().toString();

        EditText editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        String weight = editTextWeight.getText().toString();

        EditText editTextHeight = (EditText) findViewById(R.id.editTextHeight);
        String height = editTextHeight.getText().toString();

        boolean tenhoErros = false;
        if ((name.length() == 0) ){
            tenhoErros = true;
            editTextName.requestFocus();
            editTextName.setError(editTextName.getHint() + "\n" +
                    "is a required field");
        }
        /*else{
            intent.putExtra(EXTRA_NOME, name);
        }*/

        else if(phone.length() == 0){
            tenhoErros = true;
            editTextPhone.requestFocus();
            editTextPhone.setError(editTextPhone.getHint() + " \n" +
                    "is a required field");
        }
        /*else{
            intent.putExtra(EXTRA_PHONE, phone);
        }*/

        else if(email.length() == 0/* || !emailValido(email)*/){
            tenhoErros = true;
            editTextEmail.requestFocus();
            editTextEmail.setError(editTextEmail.getHint() + "\n" + "is a required field");
        }
        /*else{
            intent.putExtra(EXTRA_EMAIL, email);
        }*/

        else if(age.length() == 0){
            tenhoErros = true;
            editTextAge.requestFocus();
            editTextAge.setError(editTextAge.getHint() + "\n" +
                    "is a required field");
        }
        /*else{
            intent.putExtra(EXTRA_AGE, age);
        }*/

        else if(weight.length() == 0){
            tenhoErros = true;
            editTextWeight.requestFocus();
            editTextWeight.setError(editTextWeight.getHint() + "\n" +
                    "is a required field");
        }
        /*else{
            intent.putExtra(EXTRA_WEIGHT, weight);
        }*/

        else if(height.length() == 0){
            tenhoErros = true;
            editTextHeight.requestFocus();
            editTextHeight.setError(editTextHeight.getHint() + "\n" +
                    "is a required field");
        }
        /*else{
            intent.putExtra(EXTRA_HEIGHT, height);
        }*/

        else/*(tenhoErros == false)*/{
            intent.putExtra(EXTRA_NOME, name);
            intent.putExtra(EXTRA_PHONE, phone);
            intent.putExtra(EXTRA_EMAIL, email);
            intent.putExtra(EXTRA_AGE, age);
            intent.putExtra(EXTRA_WEIGHT, weight);
            intent.putExtra(EXTRA_HEIGHT, height);
            startActivity(intent);
        }

    }

    //--------------------------------- VALIDACOES -------------------------------------------------
    public static boolean emailValido(String email){
        final String regex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
