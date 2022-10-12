package com.example.ativ2loginecadastro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ativ2loginecadastro.R;

import Helper.DBHelper;

public class CadastroActivity extends AppCompatActivity {

    EditText Nome, Email, Senha;
    Button botaoCadastrar;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Nome =  findViewById(R.id.editTextNome);
        Email = findViewById(R.id.editTextEmail);
        Senha = findViewById(R.id.editTextSenha);
        botaoCadastrar=findViewById(R.id.buttonCadastrar);

        DB = new DBHelper(this);

        botaoCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String em = Email.getText().toString();
                String nom = Nome.getText().toString();
                String sen = Senha.getText().toString();
                if (TextUtils.isEmpty(em) || TextUtils.isEmpty(nom) || TextUtils.isEmpty(sen)) {
                    Toast.makeText(CadastroActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkemail = DB.checkemail(em);
                    if (checkemail == false) {
                        Boolean insert = DB.insertData(nom, sen, em);
                        if (insert == true) {
                            Toast.makeText(CadastroActivity.this, "Registro com sucesso", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(CadastroActivity.this, "Erro no Registro", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(CadastroActivity.this, "Usuário já registrado", Toast.LENGTH_SHORT).show();
                    }
                }
            }});
    }

    }