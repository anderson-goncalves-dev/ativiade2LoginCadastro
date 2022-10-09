package com.example.ativ2loginecadastro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ativ2loginecadastro.R;

public class CadastroActivity extends AppCompatActivity {

    EditText Nome, Email, Senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Nome = (EditText) findViewById(R.id.editTextNome);
        Email = (EditText) findViewById(R.id.editTextEmail);
        Senha = (EditText) findViewById(R.id.editTextSenha);
    }
    public void Cadastro(View v){
        if(validar()){
            Toast.makeText(this, "Confirmado", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean validar(){
        boolean retorno=true;

        String c1=Email.getText().toString();
        String c2=Senha.getText().toString();
        String c3=Nome.getText().toString();

        if(c1.isEmpty()){
            Email.setError("Este campo não pode estar vazio");
            retorno=false;
        }
        if (c2.isEmpty()){
            Senha.setError("Este campo não pode estar vazio");
            retorno =false;
        }
        if (c3.isEmpty()){
            Nome.setError("Este campo não pode estar vazio");
            retorno =false;
        }

        return retorno;

    }
}