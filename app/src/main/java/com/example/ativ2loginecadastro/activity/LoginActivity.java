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
import com.example.ativ2loginecadastro.activity.CadastroActivity;

import Helper.DBHelper;

public class LoginActivity extends AppCompatActivity {
    EditText EmailLogin, SenhaLogin;
    Button botaoLogar;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EmailLogin =  findViewById(R.id.editTextEmailLogin);
        SenhaLogin =  findViewById(R.id.editTextSenhaLogin);
        botaoLogar = findViewById(R.id.buttonLogar);
        DB=new DBHelper(this);

        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em=EmailLogin.getText().toString();
                String sen=SenhaLogin.getText().toString();
                if(TextUtils.isEmpty(em) || TextUtils.isEmpty(sen))
                    Toast.makeText(LoginActivity.this, "Preencha os campos", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkemsen=DB.checksenha(em,sen);
                    if(checkemsen==true){
                        Toast.makeText(LoginActivity.this, "Login com sucesso", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Falha ao logar", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public void cadastrar(View v){
        Intent i = new Intent(this,CadastroActivity.class);
        startActivity(i);
    }

}