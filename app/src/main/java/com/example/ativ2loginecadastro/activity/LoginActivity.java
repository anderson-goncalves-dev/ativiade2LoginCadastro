package com.example.ativ2loginecadastro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ativ2loginecadastro.R;

public class LoginActivity extends AppCompatActivity {
    EditText EmailLogin, SenhaLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EmailLogin = (EditText) findViewById(R.id.editTextEmailLogin);
        SenhaLogin = (EditText) findViewById(R.id.editTextSenhaLogin);
    }
    public void Logar(View v){
        if(validar()){
            Toast.makeText(this, "Confirmado", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean validar(){
        boolean retorno=true;

        String c1=EmailLogin.getText().toString();
        String c2=SenhaLogin.getText().toString();

        if(c1.isEmpty()){
            EmailLogin.setError("Este campo não pode estar vazio");
            retorno=false;
        }
        if (c2.isEmpty()){
            SenhaLogin.setError("Este campo não pode estar vazio");
            retorno =false;
        }

        return retorno;

    }
    public void cadastrar( View v){
        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
    }
}