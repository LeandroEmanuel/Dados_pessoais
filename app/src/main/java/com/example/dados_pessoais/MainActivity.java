package com.example.dados_pessoais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.method.TextKeyListener;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


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

        if ((name.length() != 0) ){
            String aux = "";
            String aux2 = name;
            int pos = 0;

            for(int i = 0; i < name.length();i++) {// correr a string caracter a caracter

                if(pos == 0)//if de controlo para maiuscula
                {
                    aux = aux + aux2.substring(0, 1).toUpperCase();
                    aux2=aux2.substring(1);// remover do aux2 a letra introduzida em aux
                    pos++;
                }
                else
                {
                    if(i == name.indexOf(" ",i))// descobrir o espaco a partir da posicao i
                    {
                        pos=0;
                    }
                    aux = aux + aux2.substring(0, 1);
                    aux2 = aux2.substring(1);
                }
            }
            name = aux;
        }

        if ((name.length() == 0) ){
            editTextName.setError(editTextName.getHint() + "\n" +
                    getString(R.string.nome_obrigatorio));
            editTextName.requestFocus();
            return;
        }

        else if (!name.matches("^([A-z][a-z]*((\\s)))+[A-z][a-z]*$")){//https://stackoverflow.com/questions/7362567/java-regex-for-full-name
            editTextName.setError(editTextName.getHint() + "\n" + getString(R.string.nome_invalido));
            editTextName.requestFocus();
            return;
        }
        /*else{
            intent.putExtra(EXTRA_NOME, name);
        }*/

        if(phone.length() == 0 /*&& email.length() == 0 */){
            editTextPhone.setError(editTextPhone.getHint() + " \n" +
                    getString(R.string.telefone_obrigatorio));
            editTextPhone.requestFocus();
            return;
        }
        else if(!phone.matches("[0-9]{9}") /*|| email.length() != 0*/){// feita por mim so aceita numeros com 9 digitos
            editTextPhone.setError(editTextPhone.getHint() + "\n" +
                    getString(R.string.numero_invalido));
        }
        /*else{
            intent.putExtra(EXTRA_PHONE, phone);
        }*/

        if(email.length() == 0 /*&& phone.length() == 0*/){
            editTextEmail.setError(editTextEmail.getHint() + "\n" + getString(R.string.email_obrigatorio));
            editTextEmail.requestFocus();
            return;
        }
        else if(!email.matches("[^@]+@[^\\.]+\\..+")){//https://www.regextester.com/99632
            editTextEmail.setError(editTextEmail.getHint() + "\n" + getString(R.string.email_invalido));
            editTextEmail.requestFocus();
            return;
        }
        /*else{
            intent.putExtra(EXTRA_EMAIL, email);
        }*/

        if(age.length() == 0){
            editTextAge.setError(editTextAge.getHint() + "\n" +
                    getString(R.string.idade_obrigatorio));
            editTextAge.requestFocus();
            return;
        }

        else if((Integer.parseInt(age) <= 0) || (Integer.parseInt(age) >= 120)){
            editTextAge.setError(editTextAge.getHint() + "\n" +
                    getString(R.string.idade_invalida));
            editTextAge.requestFocus();
            return;
        }
        /*else{
            intent.putExtra(EXTRA_AGE, age);
        }*/

        if(weight.length() == 0){
            editTextWeight.setError(editTextWeight.getHint() + "\n" +
                    getString(R.string.peso_obrigatorio));
            editTextWeight.requestFocus();
            return;
        }
        else if(Float.parseFloat(weight) <= 0 || Float.parseFloat(weight) >600){
            editTextWeight.setError(editTextWeight.getHint() +"\n" +
                    getString(R.string.peso_invalido));
            editTextWeight.requestFocus();
            return;
        }
        /*else{
            intent.putExtra(EXTRA_WEIGHT, weight);
        }*/

        if(height.length() == 0){
            editTextHeight.setError(editTextHeight.getHint() + "\n" +
                    getString(R.string.altura_obrigatoria));
            editTextHeight.requestFocus();
            return;
        }
        else if(Float.parseFloat(height) <= 0.8 || Float.parseFloat(height) > 2.6){
            editTextHeight.setError(editTextHeight.getHint() + "\n" +
                    getString(R.string.altura_invalida));
            editTextHeight.requestFocus();
            return;
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
            editTextName.setText("");
            editTextPhone.setText("");
            editTextEmail.setText("");
            editTextAge.setText("");
            editTextWeight.setText("");
            editTextHeight.setText("");
        }

    }

    //--------------------------------- VALIDACOES -------------------------------------------------
    /*public static boolean emailValido(String Email){
        final String regex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Email);
        return matcher.matches();
    }*/
}
